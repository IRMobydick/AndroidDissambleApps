package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.BitArray;
import com.squareup.okhttp.internal.BitArray.FixedCapacity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class HpackDraft07
{
  private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
  private static final int PREFIX_4_BITS = 15;
  private static final int PREFIX_6_BITS = 63;
  private static final int PREFIX_7_BITS = 127;
  private static final Header[] STATIC_HEADER_TABLE;

  static
  {
    Header[] arrayOfHeader = new Header[61];
    arrayOfHeader[0] = new Header(Header.TARGET_AUTHORITY, "");
    arrayOfHeader[1] = new Header(Header.TARGET_METHOD, "GET");
    arrayOfHeader[2] = new Header(Header.TARGET_METHOD, "POST");
    arrayOfHeader[3] = new Header(Header.TARGET_PATH, "/");
    arrayOfHeader[4] = new Header(Header.TARGET_PATH, "/index.html");
    arrayOfHeader[5] = new Header(Header.TARGET_SCHEME, "http");
    arrayOfHeader[6] = new Header(Header.TARGET_SCHEME, "https");
    arrayOfHeader[7] = new Header(Header.RESPONSE_STATUS, "200");
    arrayOfHeader[8] = new Header(Header.RESPONSE_STATUS, "204");
    arrayOfHeader[9] = new Header(Header.RESPONSE_STATUS, "206");
    arrayOfHeader[10] = new Header(Header.RESPONSE_STATUS, "304");
    arrayOfHeader[11] = new Header(Header.RESPONSE_STATUS, "400");
    arrayOfHeader[12] = new Header(Header.RESPONSE_STATUS, "404");
    arrayOfHeader[13] = new Header(Header.RESPONSE_STATUS, "500");
    arrayOfHeader[14] = new Header("accept-charset", "");
    arrayOfHeader[15] = new Header("accept-encoding", "");
    arrayOfHeader[16] = new Header("accept-language", "");
    arrayOfHeader[17] = new Header("accept-ranges", "");
    arrayOfHeader[18] = new Header("accept", "");
    arrayOfHeader[19] = new Header("access-control-allow-origin", "");
    arrayOfHeader[20] = new Header("age", "");
    arrayOfHeader[21] = new Header("allow", "");
    arrayOfHeader[22] = new Header("authorization", "");
    arrayOfHeader[23] = new Header("cache-control", "");
    arrayOfHeader[24] = new Header("content-disposition", "");
    arrayOfHeader[25] = new Header("content-encoding", "");
    arrayOfHeader[26] = new Header("content-language", "");
    arrayOfHeader[27] = new Header("content-length", "");
    arrayOfHeader[28] = new Header("content-location", "");
    arrayOfHeader[29] = new Header("content-range", "");
    arrayOfHeader[30] = new Header("content-type", "");
    arrayOfHeader[31] = new Header("cookie", "");
    arrayOfHeader[32] = new Header("date", "");
    arrayOfHeader[33] = new Header("etag", "");
    arrayOfHeader[34] = new Header("expect", "");
    arrayOfHeader[35] = new Header("expires", "");
    arrayOfHeader[36] = new Header("from", "");
    arrayOfHeader[37] = new Header("host", "");
    arrayOfHeader[38] = new Header("if-match", "");
    arrayOfHeader[39] = new Header("if-modified-since", "");
    arrayOfHeader[40] = new Header("if-none-match", "");
    arrayOfHeader[41] = new Header("if-range", "");
    arrayOfHeader[42] = new Header("if-unmodified-since", "");
    arrayOfHeader[43] = new Header("last-modified", "");
    arrayOfHeader[44] = new Header("link", "");
    arrayOfHeader[45] = new Header("location", "");
    arrayOfHeader[46] = new Header("max-forwards", "");
    arrayOfHeader[47] = new Header("proxy-authenticate", "");
    arrayOfHeader[48] = new Header("proxy-authorization", "");
    arrayOfHeader[49] = new Header("range", "");
    arrayOfHeader[50] = new Header("referer", "");
    arrayOfHeader[51] = new Header("refresh", "");
    arrayOfHeader[52] = new Header("retry-after", "");
    arrayOfHeader[53] = new Header("server", "");
    arrayOfHeader[54] = new Header("set-cookie", "");
    arrayOfHeader[55] = new Header("strict-transport-security", "");
    arrayOfHeader[56] = new Header("transfer-encoding", "");
    arrayOfHeader[57] = new Header("user-agent", "");
    arrayOfHeader[58] = new Header("vary", "");
    arrayOfHeader[59] = new Header("via", "");
    arrayOfHeader[60] = new Header("www-authenticate", "");
    STATIC_HEADER_TABLE = arrayOfHeader;
  }

  private static ByteString checkLowercase(ByteString paramByteString)
    throws IOException
  {
    int i = 0;
    int j = paramByteString.size();
    while (i < j)
    {
      int k = paramByteString.getByte(i);
      if ((k >= 65) && (k <= 90))
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramByteString.utf8());
      i++;
    }
    return paramByteString;
  }

  private static Map<ByteString, Integer> nameToFirstIndex()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    for (int i = 0; i < STATIC_HEADER_TABLE.length; i++)
      if (!localLinkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name))
        localLinkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
    return Collections.unmodifiableMap(localLinkedHashMap);
  }

  static final class Reader
  {
    private final List<Header> emittedHeaders = new ArrayList();
    BitArray emittedReferencedHeaders = new BitArray.FixedCapacity();
    int headerCount = 0;
    Header[] headerTable = new Header[8];
    int headerTableByteCount = 0;
    private int maxHeaderTableByteCount;
    private int maxHeaderTableByteCountSetting;
    int nextHeaderIndex = -1 + this.headerTable.length;
    BitArray referencedHeaders = new BitArray.FixedCapacity();
    private final BufferedSource source;

    Reader(int paramInt, Source paramSource)
    {
      this.maxHeaderTableByteCountSetting = paramInt;
      this.maxHeaderTableByteCount = paramInt;
      this.source = Okio.buffer(paramSource);
    }

    private void adjustHeaderTableByteCount()
    {
      if (this.maxHeaderTableByteCount < this.headerTableByteCount)
      {
        if (this.maxHeaderTableByteCount == 0)
          clearHeaderTable();
      }
      else
        return;
      evictToRecoverBytes(this.headerTableByteCount - this.maxHeaderTableByteCount);
    }

    private void clearHeaderTable()
    {
      clearReferenceSet();
      Arrays.fill(this.headerTable, null);
      this.nextHeaderIndex = (-1 + this.headerTable.length);
      this.headerCount = 0;
      this.headerTableByteCount = 0;
    }

    private void clearReferenceSet()
    {
      this.referencedHeaders.clear();
      this.emittedReferencedHeaders.clear();
    }

    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      if (paramInt > 0)
      {
        for (int j = -1 + this.headerTable.length; (j >= this.nextHeaderIndex) && (paramInt > 0); j--)
        {
          paramInt -= this.headerTable[j].hpackSize;
          this.headerTableByteCount -= this.headerTable[j].hpackSize;
          this.headerCount = (-1 + this.headerCount);
          i++;
        }
        this.referencedHeaders.shiftLeft(i);
        this.emittedReferencedHeaders.shiftLeft(i);
        System.arraycopy(this.headerTable, 1 + this.nextHeaderIndex, this.headerTable, i + (1 + this.nextHeaderIndex), this.headerCount);
        this.nextHeaderIndex = (i + this.nextHeaderIndex);
      }
      return i;
    }

    private ByteString getName(int paramInt)
    {
      if (isStaticHeader(paramInt))
        return HpackDraft07.STATIC_HEADER_TABLE[(paramInt - this.headerCount)].name;
      return this.headerTable[headerTableIndex(paramInt)].name;
    }

    private int headerTableIndex(int paramInt)
    {
      return paramInt + (1 + this.nextHeaderIndex);
    }

    private void insertIntoHeaderTable(int paramInt, Header paramHeader)
    {
      int i = paramHeader.hpackSize;
      if (paramInt != -1)
        i -= this.headerTable[headerTableIndex(paramInt)].hpackSize;
      if (i > this.maxHeaderTableByteCount)
      {
        clearHeaderTable();
        this.emittedHeaders.add(paramHeader);
        return;
      }
      int j = evictToRecoverBytes(i + this.headerTableByteCount - this.maxHeaderTableByteCount);
      if (paramInt == -1)
      {
        if (1 + this.headerCount > this.headerTable.length)
        {
          Header[] arrayOfHeader = new Header[2 * this.headerTable.length];
          System.arraycopy(this.headerTable, 0, arrayOfHeader, this.headerTable.length, this.headerTable.length);
          if (arrayOfHeader.length == 64)
          {
            this.referencedHeaders = ((BitArray.FixedCapacity)this.referencedHeaders).toVariableCapacity();
            this.emittedReferencedHeaders = ((BitArray.FixedCapacity)this.emittedReferencedHeaders).toVariableCapacity();
          }
          this.referencedHeaders.shiftLeft(this.headerTable.length);
          this.emittedReferencedHeaders.shiftLeft(this.headerTable.length);
          this.nextHeaderIndex = (-1 + this.headerTable.length);
          this.headerTable = arrayOfHeader;
        }
        int m = this.nextHeaderIndex;
        this.nextHeaderIndex = (m - 1);
        this.referencedHeaders.set(m);
        this.headerTable[m] = paramHeader;
        this.headerCount = (1 + this.headerCount);
      }
      while (true)
      {
        this.headerTableByteCount = (i + this.headerTableByteCount);
        return;
        int k = paramInt + (j + headerTableIndex(paramInt));
        this.referencedHeaders.set(k);
        this.headerTable[k] = paramHeader;
      }
    }

    private boolean isStaticHeader(int paramInt)
    {
      return paramInt >= this.headerCount;
    }

    private int readByte()
      throws IOException
    {
      return 0xFF & this.source.readByte();
    }

    private void readIndexedHeader(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt))
      {
        int j = paramInt - this.headerCount;
        if (j > -1 + HpackDraft07.STATIC_HEADER_TABLE.length)
          throw new IOException("Header index too large " + (j + 1));
        Header localHeader = HpackDraft07.STATIC_HEADER_TABLE[j];
        if (this.maxHeaderTableByteCount == 0)
        {
          this.emittedHeaders.add(localHeader);
          return;
        }
        insertIntoHeaderTable(-1, localHeader);
        return;
      }
      int i = headerTableIndex(paramInt);
      if (!this.referencedHeaders.get(i))
      {
        this.emittedHeaders.add(this.headerTable[i]);
        this.emittedReferencedHeaders.set(i);
      }
      this.referencedHeaders.toggle(i);
    }

    private void readLiteralHeaderWithIncrementalIndexingIndexedName(int paramInt)
      throws IOException
    {
      insertIntoHeaderTable(-1, new Header(getName(paramInt), readByteString()));
    }

    private void readLiteralHeaderWithIncrementalIndexingNewName()
      throws IOException
    {
      insertIntoHeaderTable(-1, new Header(HpackDraft07.checkLowercase(readByteString()), readByteString()));
    }

    private void readLiteralHeaderWithoutIndexingIndexedName(int paramInt)
      throws IOException
    {
      ByteString localByteString1 = getName(paramInt);
      ByteString localByteString2 = readByteString();
      this.emittedHeaders.add(new Header(localByteString1, localByteString2));
    }

    private void readLiteralHeaderWithoutIndexingNewName()
      throws IOException
    {
      ByteString localByteString1 = HpackDraft07.checkLowercase(readByteString());
      ByteString localByteString2 = readByteString();
      this.emittedHeaders.add(new Header(localByteString1, localByteString2));
    }

    void emitReferenceSet()
    {
      for (int i = -1 + this.headerTable.length; i != this.nextHeaderIndex; i--)
        if ((this.referencedHeaders.get(i)) && (!this.emittedReferencedHeaders.get(i)))
          this.emittedHeaders.add(this.headerTable[i]);
    }

    List<Header> getAndReset()
    {
      ArrayList localArrayList = new ArrayList(this.emittedHeaders);
      this.emittedHeaders.clear();
      this.emittedReferencedHeaders.clear();
      return localArrayList;
    }

    int maxHeaderTableByteCount()
    {
      return this.maxHeaderTableByteCount;
    }

    void maxHeaderTableByteCountSetting(int paramInt)
    {
      this.maxHeaderTableByteCountSetting = paramInt;
      this.maxHeaderTableByteCount = this.maxHeaderTableByteCountSetting;
      adjustHeaderTableByteCount();
    }

    ByteString readByteString()
      throws IOException
    {
      int i = readByte();
      if ((i & 0x80) == 128);
      int k;
      for (int j = 1; ; j = 0)
      {
        k = readInt(i, 127);
        if (j == 0)
          break;
        return ByteString.of(Huffman.get().decode(this.source.readByteArray(k)));
      }
      return this.source.readByteString(k);
    }

    void readHeaders()
      throws IOException
    {
      while (!this.source.exhausted())
      {
        int i = 0xFF & this.source.readByte();
        if (i == 128)
          throw new IOException("index == 0");
        if ((i & 0x80) == 128)
          readIndexedHeader(-1 + readInt(i, 127));
        else if (i == 64)
          readLiteralHeaderWithIncrementalIndexingNewName();
        else if ((i & 0x40) == 64)
          readLiteralHeaderWithIncrementalIndexingIndexedName(-1 + readInt(i, 63));
        else if ((i & 0x20) == 32)
        {
          if ((i & 0x10) == 16)
          {
            if ((i & 0xF) != 0)
              throw new IOException("Invalid header table state change " + i);
            clearReferenceSet();
          }
          else
          {
            this.maxHeaderTableByteCount = readInt(i, 15);
            if ((this.maxHeaderTableByteCount < 0) || (this.maxHeaderTableByteCount > this.maxHeaderTableByteCountSetting))
              throw new IOException("Invalid header table byte count " + this.maxHeaderTableByteCount);
            adjustHeaderTableByteCount();
          }
        }
        else if ((i == 16) || (i == 0))
          readLiteralHeaderWithoutIndexingNewName();
        else
          readLiteralHeaderWithoutIndexingIndexedName(-1 + readInt(i, 15));
      }
    }

    int readInt(int paramInt1, int paramInt2)
      throws IOException
    {
      int i = paramInt1 & paramInt2;
      if (i < paramInt2)
        return i;
      int j = paramInt2;
      int m;
      for (int k = 0; ; k += 7)
      {
        m = readByte();
        if ((m & 0x80) == 0)
          break;
        j += ((m & 0x7F) << k);
      }
      return j + (m << k);
    }
  }

  static final class Writer
  {
    private final Buffer out;

    Writer(Buffer paramBuffer)
    {
      this.out = paramBuffer;
    }

    void writeByteString(ByteString paramByteString)
      throws IOException
    {
      writeInt(paramByteString.size(), 127, 0);
      this.out.write(paramByteString);
    }

    void writeHeaders(List<Header> paramList)
      throws IOException
    {
      int i = 0;
      int j = paramList.size();
      if (i < j)
      {
        ByteString localByteString = ((Header)paramList.get(i)).name.toAsciiLowercase();
        Integer localInteger = (Integer)HpackDraft07.NAME_TO_FIRST_INDEX.get(localByteString);
        if (localInteger != null)
        {
          writeInt(1 + localInteger.intValue(), 15, 0);
          writeByteString(((Header)paramList.get(i)).value);
        }
        while (true)
        {
          i++;
          break;
          this.out.writeByte(0);
          writeByteString(localByteString);
          writeByteString(((Header)paramList.get(i)).value);
        }
      }
    }

    void writeInt(int paramInt1, int paramInt2, int paramInt3)
      throws IOException
    {
      if (paramInt1 < paramInt2)
      {
        this.out.writeByte(paramInt3 | paramInt1);
        return;
      }
      this.out.writeByte(paramInt3 | paramInt2);
      int i = paramInt1 - paramInt2;
      while (i >= 128)
      {
        int j = i & 0x7F;
        this.out.writeByte(j | 0x80);
        i >>>= 7;
      }
      this.out.writeByte(i);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.spdy.HpackDraft07
 * JD-Core Version:    0.6.2
 */