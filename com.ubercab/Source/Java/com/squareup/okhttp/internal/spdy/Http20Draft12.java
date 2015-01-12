package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Http20Draft12
  implements Variant
{
  private static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_SEGMENT = 2;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PAD_HIGH = 16;
  static final byte FLAG_PAD_LOW = 8;
  static final byte FLAG_PRIORITY = 32;
  static final int MAX_FRAME_SIZE = 16383;
  static final byte TYPE_ALTSVC = 10;
  static final byte TYPE_BLOCKED = 11;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;
  private static final Logger logger = Logger.getLogger(Http20Draft12.class.getName());

  private static IllegalArgumentException illegalArgument(String paramString, Object[] paramArrayOfObject)
  {
    throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  private static IOException ioException(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    throw new IOException(String.format(paramString, paramArrayOfObject));
  }

  private static short lengthWithoutPadding(short paramShort1, byte paramByte, short paramShort2)
    throws IOException
  {
    if ((paramByte & 0x10) != 0)
      paramShort1 = (short)(paramShort1 - 2);
    while (paramShort2 > paramShort1)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Short.valueOf(paramShort2);
      arrayOfObject[1] = Short.valueOf(paramShort1);
      throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", arrayOfObject);
      if ((paramByte & 0x8) != 0)
        paramShort1 = (short)(paramShort1 - 1);
    }
    return (short)(paramShort1 - paramShort2);
  }

  private static short readPadding(BufferedSource paramBufferedSource, byte paramByte)
    throws IOException
  {
    if (((paramByte & 0x10) != 0) && ((paramByte & 0x8) == 0))
      throw ioException("PROTOCOL_ERROR FLAG_PAD_HIGH set without FLAG_PAD_LOW", new Object[0]);
    int j;
    if ((paramByte & 0x10) != 0)
      j = 0xFFFF & paramBufferedSource.readShort();
    while (j > 16383)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(16383);
      arrayOfObject[1] = Integer.valueOf(j);
      throw ioException("PROTOCOL_ERROR padding > %d: %d", arrayOfObject);
      int i = paramByte & 0x8;
      j = 0;
      if (i != 0)
        j = 0xFF & paramBufferedSource.readByte();
    }
    return (short)j;
  }

  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }

  public int maxFrameSize()
  {
    return 16383;
  }

  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    return new Reader(paramBufferedSource, 4096, paramBoolean);
  }

  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return new Writer(paramBufferedSink, paramBoolean);
  }

  static final class ContinuationSource
    implements Source
  {
    byte flags;
    short left;
    short length;
    short padding;
    private final BufferedSource source;
    int streamId;

    public ContinuationSource(BufferedSource paramBufferedSource)
    {
      this.source = paramBufferedSource;
    }

    private void readContinuationHeader()
      throws IOException
    {
      int i = this.streamId;
      int j = this.source.readInt();
      int k = this.source.readInt();
      this.length = ((short)((0x3FFF0000 & j) >> 16));
      byte b = (byte)((0xFF00 & j) >> 8);
      this.flags = ((byte)(j & 0xFF));
      if (Http20Draft12.logger.isLoggable(Level.FINE))
        Http20Draft12.logger.fine(Http20Draft12.FrameLogger.formatHeader(true, this.streamId, this.length, b, this.flags));
      this.padding = Http20Draft12.readPadding(this.source, this.flags);
      short s = Http20Draft12.lengthWithoutPadding(this.length, this.flags, this.padding);
      this.left = s;
      this.length = s;
      this.streamId = (0x7FFFFFFF & k);
      if (b != 9)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(b);
        throw Http20Draft12.ioException("%s != TYPE_CONTINUATION", arrayOfObject);
      }
      if (this.streamId != i)
        throw Http20Draft12.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
    }

    public void close()
      throws IOException
    {
    }

    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      while (this.left == 0)
      {
        this.source.skip(this.padding);
        this.padding = 0;
        if ((0x4 & this.flags) != 0)
          return -1L;
        readContinuationHeader();
      }
      long l = this.source.read(paramBuffer, Math.min(paramLong, this.left));
      if (l == -1L)
        return -1L;
      this.left = ((short)(int)(this.left - l));
      return l;
    }

    public Timeout timeout()
    {
      return this.source.timeout();
    }
  }

  static final class FrameLogger
  {
    private static final String[] BINARY;
    private static final String[] FLAGS;
    private static final String[] TYPES = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION", "ALTSVC", "BLOCKED" };

    static
    {
      FLAGS = new String[64];
      BINARY = new String[256];
      for (int i = 0; i < BINARY.length; i++)
      {
        String[] arrayOfString = BINARY;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.toBinaryString(i);
        arrayOfString[i] = String.format("%8s", arrayOfObject).replace(' ', '0');
      }
      FLAGS[0] = "";
      FLAGS[1] = "END_STREAM";
      FLAGS[2] = "END_SEGMENT";
      FLAGS[3] = "END_STREAM|END_SEGMENT";
      int[] arrayOfInt1 = { 1, 2, 3 };
      FLAGS[8] = "PAD_LOW";
      FLAGS[24] = "PAD_LOW|PAD_HIGH";
      int[] arrayOfInt2 = { 8, 24 };
      int j = arrayOfInt1.length;
      for (int k = 0; k < j; k++)
      {
        int i9 = arrayOfInt1[k];
        int i10 = arrayOfInt2.length;
        for (int i11 = 0; i11 < i10; i11++)
        {
          int i12 = arrayOfInt2[i11];
          FLAGS[(i9 | i12)] = (FLAGS[i9] + '|' + FLAGS[i12]);
        }
      }
      FLAGS[4] = "END_HEADERS";
      FLAGS[32] = "PRIORITY";
      FLAGS[36] = "END_HEADERS|PRIORITY";
      for (int i2 : new int[] { 4, 32, 36 })
      {
        int i3 = arrayOfInt1.length;
        for (int i4 = 0; i4 < i3; i4++)
        {
          int i5 = arrayOfInt1[i4];
          FLAGS[(i5 | i2)] = (FLAGS[i5] + '|' + FLAGS[i2]);
          int i6 = arrayOfInt2.length;
          for (int i7 = 0; i7 < i6; i7++)
          {
            int i8 = arrayOfInt2[i7];
            FLAGS[(i8 | (i5 | i2))] = (FLAGS[i5] + '|' + FLAGS[i2] + '|' + FLAGS[i8]);
          }
        }
      }
      for (int i1 = 0; i1 < FLAGS.length; i1++)
        if (FLAGS[i1] == null)
          FLAGS[i1] = BINARY[i1];
    }

    static String formatFlags(byte paramByte1, byte paramByte2)
    {
      if (paramByte2 == 0)
        return "";
      switch (paramByte1)
      {
      case 5:
      case 9:
      default:
        if (paramByte2 >= FLAGS.length)
          break;
      case 4:
      case 6:
      case 2:
      case 3:
      case 7:
      case 8:
      case 10:
      case 11:
      }
      for (String str = FLAGS[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = BINARY[paramByte2])
      {
        return str.replace("HEADERS", "PUSH_PROMISE");
        if (paramByte2 == 1)
          return "ACK";
        return BINARY[paramByte2];
        return BINARY[paramByte2];
      }
      if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0))
        return str.replace("PRIORITY", "COMPRESSED");
      return str;
    }

    static String formatHeader(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    {
      String str1;
      String str2;
      Object[] arrayOfObject2;
      if (paramByte1 < TYPES.length)
      {
        str1 = TYPES[paramByte1];
        str2 = formatFlags(paramByte1, paramByte2);
        arrayOfObject2 = new Object[5];
        if (!paramBoolean)
          break label105;
      }
      label105: for (String str3 = "<<"; ; str3 = ">>")
      {
        arrayOfObject2[0] = str3;
        arrayOfObject2[1] = Integer.valueOf(paramInt1);
        arrayOfObject2[2] = Integer.valueOf(paramInt2);
        arrayOfObject2[3] = str1;
        arrayOfObject2[4] = str2;
        return String.format("%s 0x%08x %5d %-13s %s", arrayOfObject2);
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Byte.valueOf(paramByte1);
        str1 = String.format("0x%02x", arrayOfObject1);
        break;
      }
    }
  }

  static final class Reader
    implements FrameReader
  {
    private final boolean client;
    private final Http20Draft12.ContinuationSource continuation;
    final HpackDraft07.Reader hpackReader;
    private final BufferedSource source;

    Reader(BufferedSource paramBufferedSource, int paramInt, boolean paramBoolean)
    {
      this.source = paramBufferedSource;
      this.client = paramBoolean;
      this.continuation = new Http20Draft12.ContinuationSource(this.source);
      this.hpackReader = new HpackDraft07.Reader(paramInt, this.continuation);
    }

    private void readAlternateService(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      long l = 0xFFFFFFFF & this.source.readInt();
      int i = 0xFFFF & this.source.readShort();
      this.source.readByte();
      int j = 0xFF & this.source.readByte();
      ByteString localByteString = this.source.readByteString(j);
      int k = 0xFF & this.source.readByte();
      String str = this.source.readUtf8(k);
      int m = paramShort - 9 - j - k;
      paramHandler.alternateService(paramInt, this.source.readUtf8(m), localByteString, str, i, l);
    }

    private void readData(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      boolean bool1 = true;
      boolean bool2;
      if ((paramByte & 0x1) != 0)
      {
        bool2 = bool1;
        if ((paramByte & 0x20) == 0)
          break label41;
      }
      while (true)
      {
        if (!bool1)
          break label47;
        throw Http20Draft12.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        bool2 = false;
        break;
        label41: bool1 = false;
      }
      label47: short s = Http20Draft12.readPadding(this.source, paramByte);
      int i = Http20Draft12.lengthWithoutPadding(paramShort, paramByte, s);
      paramHandler.data(bool2, paramInt, this.source, i);
      this.source.skip(s);
    }

    private void readGoAway(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort < 8)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Short.valueOf(paramShort);
        throw Http20Draft12.ioException("TYPE_GOAWAY length < 8: %s", arrayOfObject2);
      }
      if (paramInt != 0)
        throw Http20Draft12.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
      int i = this.source.readInt();
      int j = this.source.readInt();
      int k = paramShort - 8;
      ErrorCode localErrorCode = ErrorCode.fromHttp2(j);
      if (localErrorCode == null)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(j);
        throw Http20Draft12.ioException("TYPE_GOAWAY unexpected error code: %d", arrayOfObject1);
      }
      ByteString localByteString = ByteString.EMPTY;
      if (k > 0)
        localByteString = this.source.readByteString(k);
      paramHandler.goAway(i, localErrorCode, localByteString);
    }

    private List<Header> readHeaderBlock(short paramShort1, short paramShort2, byte paramByte, int paramInt)
      throws IOException
    {
      Http20Draft12.ContinuationSource localContinuationSource = this.continuation;
      this.continuation.left = paramShort1;
      localContinuationSource.length = paramShort1;
      this.continuation.padding = paramShort2;
      this.continuation.flags = paramByte;
      this.continuation.streamId = paramInt;
      this.hpackReader.readHeaders();
      this.hpackReader.emitReferenceSet();
      return this.hpackReader.getAndReset();
    }

    private void readHeaders(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt == 0)
        throw Http20Draft12.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
      if ((paramByte & 0x1) != 0);
      for (boolean bool = true; ; bool = false)
      {
        short s = Http20Draft12.readPadding(this.source, paramByte);
        if ((paramByte & 0x20) != 0)
        {
          readPriority(paramHandler, paramInt);
          paramShort = (short)(paramShort - 5);
        }
        paramHandler.headers(false, bool, paramInt, -1, readHeaderBlock(Http20Draft12.lengthWithoutPadding(paramShort, paramByte, s), s, paramByte, paramInt), HeadersMode.HTTP_20_HEADERS);
        return;
      }
    }

    private void readPing(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      boolean bool = true;
      if (paramShort != 8)
      {
        Object[] arrayOfObject = new Object[bool];
        arrayOfObject[0] = Short.valueOf(paramShort);
        throw Http20Draft12.ioException("TYPE_PING length != 8: %s", arrayOfObject);
      }
      if (paramInt != 0)
        throw Http20Draft12.ioException("TYPE_PING streamId != 0", new Object[0]);
      int i = this.source.readInt();
      int j = this.source.readInt();
      if ((paramByte & 0x1) != 0);
      while (true)
      {
        paramHandler.ping(bool, i, j);
        return;
        bool = false;
      }
    }

    private void readPriority(FrameReader.Handler paramHandler, int paramInt)
      throws IOException
    {
      int i = this.source.readInt();
      if ((0x80000000 & i) != 0);
      for (boolean bool = true; ; bool = false)
      {
        paramHandler.priority(paramInt, i & 0x7FFFFFFF, 1 + (0xFF & this.source.readByte()), bool);
        return;
      }
    }

    private void readPriority(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 5)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Short.valueOf(paramShort);
        throw Http20Draft12.ioException("TYPE_PRIORITY length: %d != 5", arrayOfObject);
      }
      if (paramInt == 0)
        throw Http20Draft12.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
      readPriority(paramHandler, paramInt);
    }

    private void readPushPromise(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt == 0)
        throw Http20Draft12.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
      short s = Http20Draft12.readPadding(this.source, paramByte);
      paramHandler.pushPromise(paramInt, 0x7FFFFFFF & this.source.readInt(), readHeaderBlock((short)(paramShort - 4), s, paramByte, paramInt));
    }

    private void readRstStream(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 4)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Short.valueOf(paramShort);
        throw Http20Draft12.ioException("TYPE_RST_STREAM length: %d != 4", arrayOfObject2);
      }
      if (paramInt == 0)
        throw Http20Draft12.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
      int i = this.source.readInt();
      ErrorCode localErrorCode = ErrorCode.fromHttp2(i);
      if (localErrorCode == null)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(i);
        throw Http20Draft12.ioException("TYPE_RST_STREAM unexpected error code: %d", arrayOfObject1);
      }
      paramHandler.rstStream(paramInt, localErrorCode);
    }

    private void readSettings(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramInt != 0)
        throw Http20Draft12.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
      if ((paramByte & 0x1) != 0)
      {
        if (paramShort != 0)
          throw Http20Draft12.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        paramHandler.ackSettings();
      }
      Settings localSettings;
      do
      {
        return;
        if (paramShort % 5 != 0)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Short.valueOf(paramShort);
          throw Http20Draft12.ioException("TYPE_SETTINGS length %% 5 != 0: %s", arrayOfObject2);
        }
        localSettings = new Settings();
        short s = 0;
        if (s < paramShort)
        {
          int i = this.source.readByte();
          int j = this.source.readInt();
          switch (i)
          {
          default:
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = Integer.valueOf(i);
            throw Http20Draft12.ioException("PROTOCOL_ERROR invalid settings id: %s", arrayOfObject1);
          case 2:
            if ((j != 0) && (j != 1))
              throw Http20Draft12.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            break;
          case 3:
            i = 4;
          case 1:
          case 5:
          case 4:
          }
          do
          {
            localSettings.set(i, 0, j);
            s += 5;
            break;
            i = 7;
          }
          while (j >= 0);
          throw Http20Draft12.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        }
        paramHandler.settings(false, localSettings);
      }
      while (localSettings.getHeaderTableSize() < 0);
      this.hpackReader.maxHeaderTableByteCountSetting(localSettings.getHeaderTableSize());
    }

    private void readWindowUpdate(FrameReader.Handler paramHandler, short paramShort, byte paramByte, int paramInt)
      throws IOException
    {
      if (paramShort != 4)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Short.valueOf(paramShort);
        throw Http20Draft12.ioException("TYPE_WINDOW_UPDATE length !=4: %s", arrayOfObject2);
      }
      long l = 0x7FFFFFFF & this.source.readInt();
      if (l == 0L)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Long.valueOf(l);
        throw Http20Draft12.ioException("windowSizeIncrement was 0", arrayOfObject1);
      }
      paramHandler.windowUpdate(paramInt, l);
    }

    public void close()
      throws IOException
    {
      this.source.close();
    }

    public boolean nextFrame(FrameReader.Handler paramHandler)
      throws IOException
    {
      boolean bool = true;
      short s;
      do
      {
        byte b2;
        int k;
        try
        {
          int i = this.source.readInt();
          int j = this.source.readInt();
          s = (short)((0x3FFF0000 & i) >> 16);
          byte b1 = (byte)((0xFF00 & i) >> 8);
          b2 = (byte)(i & 0xFF);
          k = j & 0x7FFFFFFF;
          if (Http20Draft12.logger.isLoggable(Level.FINE))
            Http20Draft12.logger.fine(Http20Draft12.FrameLogger.formatHeader(bool, k, s, b1, b2));
          switch (b1)
          {
          case 9:
          default:
            Object[] arrayOfObject2 = new Object[bool];
            arrayOfObject2[0] = Byte.valueOf(b1);
            throw Http20Draft12.ioException("PROTOCOL_ERROR: unknown frame type %s", arrayOfObject2);
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 10:
          case 11:
          }
        }
        catch (IOException localIOException)
        {
          bool = false;
          return bool;
        }
        readData(paramHandler, s, b2, k);
        return bool;
        readHeaders(paramHandler, s, b2, k);
        return bool;
        readPriority(paramHandler, s, b2, k);
        return bool;
        readRstStream(paramHandler, s, b2, k);
        return bool;
        readSettings(paramHandler, s, b2, k);
        return bool;
        readPushPromise(paramHandler, s, b2, k);
        return bool;
        readPing(paramHandler, s, b2, k);
        return bool;
        readGoAway(paramHandler, s, b2, k);
        return bool;
        readWindowUpdate(paramHandler, s, b2, k);
        return bool;
        readAlternateService(paramHandler, s, b2, k);
        return bool;
      }
      while (s == 0);
      Object[] arrayOfObject1 = new Object[bool];
      arrayOfObject1[0] = Short.valueOf(s);
      throw Http20Draft12.ioException("TYPE_BLOCKED length != 0: %s", arrayOfObject1);
    }

    public void readConnectionPreface()
      throws IOException
    {
      if (this.client);
      ByteString localByteString;
      do
      {
        return;
        localByteString = this.source.readByteString(Http20Draft12.CONNECTION_PREFACE.size());
        if (Http20Draft12.logger.isLoggable(Level.FINE))
        {
          Logger localLogger = Http20Draft12.logger;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = localByteString.hex();
          localLogger.fine(String.format("<< CONNECTION %s", arrayOfObject2));
        }
      }
      while (Http20Draft12.CONNECTION_PREFACE.equals(localByteString));
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localByteString.utf8();
      throw Http20Draft12.ioException("Expected a connection header but was %s", arrayOfObject1);
    }
  }

  static final class Writer
    implements FrameWriter
  {
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final HpackDraft07.Writer hpackWriter;
    private final BufferedSink sink;

    Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
    {
      this.sink = paramBufferedSink;
      this.client = paramBoolean;
      this.hpackBuffer = new Buffer();
      this.hpackWriter = new HpackDraft07.Writer(this.hpackBuffer);
    }

    private void writeContinuationFrames(int paramInt, long paramLong)
      throws IOException
    {
      if (paramLong > 0L)
      {
        int i = (int)Math.min(16383L, paramLong);
        paramLong -= i;
        if (paramLong == 0L);
        for (byte b = 4; ; b = 0)
        {
          frameHeader(paramInt, i, (byte)9, b);
          this.sink.write(this.hpackBuffer, i);
          break;
        }
      }
    }

    public void ackSettings()
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      frameHeader(0, 0, (byte)4, (byte)1);
      this.sink.flush();
    }

    public void close()
      throws IOException
    {
      try
      {
        this.closed = true;
        this.sink.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void connectionPreface()
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      boolean bool = this.client;
      if (!bool);
      while (true)
      {
        return;
        if (Http20Draft12.logger.isLoggable(Level.FINE))
        {
          Logger localLogger = Http20Draft12.logger;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Http20Draft12.CONNECTION_PREFACE.hex();
          localLogger.fine(String.format(">> CONNECTION %s", arrayOfObject));
        }
        this.sink.write(Http20Draft12.CONNECTION_PREFACE.toByteArray());
        this.sink.flush();
      }
    }

    public void data(boolean paramBoolean, int paramInt, Buffer paramBuffer)
      throws IOException
    {
      try
      {
        data(paramBoolean, paramInt, paramBuffer, (int)paramBuffer.size());
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      byte b = 0;
      if (paramBoolean)
        b = (byte)1;
      dataFrame(paramInt1, b, paramBuffer, paramInt2);
    }

    void dataFrame(int paramInt1, byte paramByte, Buffer paramBuffer, int paramInt2)
      throws IOException
    {
      frameHeader(paramInt1, paramInt2, (byte)0, paramByte);
      if (paramInt2 > 0)
        this.sink.write(paramBuffer, paramInt2);
    }

    public void flush()
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      this.sink.flush();
    }

    void frameHeader(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
      throws IOException
    {
      if (Http20Draft12.logger.isLoggable(Level.FINE))
        Http20Draft12.logger.fine(Http20Draft12.FrameLogger.formatHeader(false, paramInt1, paramInt2, paramByte1, paramByte2));
      if (paramInt2 > 16383)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Integer.valueOf(16383);
        arrayOfObject2[1] = Integer.valueOf(paramInt2);
        throw Http20Draft12.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", arrayOfObject2);
      }
      if ((0x80000000 & paramInt1) != 0)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(paramInt1);
        throw Http20Draft12.illegalArgument("reserved bit set: %s", arrayOfObject1);
      }
      this.sink.writeInt((paramInt2 & 0x3FFF) << 16 | (paramByte1 & 0xFF) << 8 | paramByte2 & 0xFF);
      this.sink.writeInt(0x7FFFFFFF & paramInt1);
    }

    public void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      if (paramErrorCode.httpCode == -1)
        throw Http20Draft12.illegalArgument("errorCode.httpCode == -1", new Object[0]);
      frameHeader(0, 8 + paramArrayOfByte.length, (byte)7, (byte)0);
      this.sink.writeInt(paramInt);
      this.sink.writeInt(paramErrorCode.httpCode);
      if (paramArrayOfByte.length > 0)
        this.sink.write(paramArrayOfByte);
      this.sink.flush();
    }

    public void headers(int paramInt, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      headers(false, paramInt, paramList);
    }

    void headers(boolean paramBoolean, int paramInt, List<Header> paramList)
      throws IOException
    {
      if (this.closed)
        throw new IOException("closed");
      if (this.hpackBuffer.size() != 0L)
        throw new IllegalStateException();
      this.hpackWriter.writeHeaders(paramList);
      long l = this.hpackBuffer.size();
      int i = (int)Math.min(16383L, l);
      if (l == i);
      for (byte b = 4; ; b = 0)
      {
        if (paramBoolean)
          b = (byte)(b | 0x1);
        frameHeader(paramInt, i, (byte)1, b);
        this.sink.write(this.hpackBuffer, i);
        if (l > i)
          writeContinuationFrames(paramInt, l - i);
        return;
      }
    }

    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      if (paramBoolean);
      for (byte b = 1; ; b = 0)
      {
        frameHeader(0, 8, (byte)6, b);
        this.sink.writeInt(paramInt1);
        this.sink.writeInt(paramInt2);
        this.sink.flush();
        return;
      }
    }

    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      if (this.hpackBuffer.size() != 0L)
        throw new IllegalStateException();
      this.hpackWriter.writeHeaders(paramList);
      long l = this.hpackBuffer.size();
      int i = (int)Math.min(16379L, l);
      if (l == i);
      for (byte b = 4; ; b = 0)
      {
        frameHeader(paramInt1, i + 4, (byte)5, b);
        this.sink.writeInt(0x7FFFFFFF & paramInt2);
        this.sink.write(this.hpackBuffer, i);
        if (l > i)
          writeContinuationFrames(paramInt1, l - i);
        return;
      }
    }

    public void rstStream(int paramInt, ErrorCode paramErrorCode)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      if (paramErrorCode.spdyRstCode == -1)
        throw new IllegalArgumentException();
      frameHeader(paramInt, 4, (byte)3, (byte)0);
      this.sink.writeInt(paramErrorCode.httpCode);
      this.sink.flush();
    }

    public void settings(Settings paramSettings)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      frameHeader(0, 5 * paramSettings.size(), (byte)4, (byte)0);
      int i = 0;
      if (i < 10)
        if (paramSettings.isSet(i))
          break label104;
      while (true)
      {
        this.sink.writeByte(j);
        this.sink.writeInt(paramSettings.get(i));
        break label98;
        this.sink.flush();
        return;
        label98: i++;
        break;
        label104: int j = i;
        if (j == 4)
          j = 3;
        else if (j == 7)
          j = 4;
      }
    }

    public void synReply(boolean paramBoolean, int paramInt, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      headers(paramBoolean, paramInt, paramList);
    }

    public void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      if (paramBoolean2)
        try
        {
          throw new UnsupportedOperationException();
        }
        finally
        {
        }
      if (this.closed)
        throw new IOException("closed");
      headers(paramBoolean1, paramInt1, paramList);
    }

    public void windowUpdate(int paramInt, long paramLong)
      throws IOException
    {
      try
      {
        if (this.closed)
          throw new IOException("closed");
      }
      finally
      {
      }
      if ((paramLong == 0L) || (paramLong > 2147483647L))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Long.valueOf(paramLong);
        throw Http20Draft12.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", arrayOfObject);
      }
      frameHeader(paramInt, 4, (byte)8, (byte)0);
      this.sink.writeInt((int)paramLong);
      this.sink.flush();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.spdy.Http20Draft12
 * JD-Core Version:    0.6.2
 */