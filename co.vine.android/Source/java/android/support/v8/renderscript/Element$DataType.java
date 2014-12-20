package android.support.v8.renderscript;

public enum Element$DataType
{
  int mID;
  int mSize;

  static
  {
    FLOAT_32 = new DataType("FLOAT_32", 1, 2, 4);
    FLOAT_64 = new DataType("FLOAT_64", 2, 3, 8);
    SIGNED_8 = new DataType("SIGNED_8", 3, 4, 1);
    SIGNED_16 = new DataType("SIGNED_16", 4, 5, 2);
    SIGNED_32 = new DataType("SIGNED_32", 5, 6, 4);
    SIGNED_64 = new DataType("SIGNED_64", 6, 7, 8);
    UNSIGNED_8 = new DataType("UNSIGNED_8", 7, 8, 1);
    UNSIGNED_16 = new DataType("UNSIGNED_16", 8, 9, 2);
    UNSIGNED_32 = new DataType("UNSIGNED_32", 9, 10, 4);
    UNSIGNED_64 = new DataType("UNSIGNED_64", 10, 11, 8);
    BOOLEAN = new DataType("BOOLEAN", 11, 12, 1);
    UNSIGNED_5_6_5 = new DataType("UNSIGNED_5_6_5", 12, 13, 2);
    UNSIGNED_5_5_5_1 = new DataType("UNSIGNED_5_5_5_1", 13, 14, 2);
    UNSIGNED_4_4_4_4 = new DataType("UNSIGNED_4_4_4_4", 14, 15, 2);
    MATRIX_4X4 = new DataType("MATRIX_4X4", 15, 16, 64);
    MATRIX_3X3 = new DataType("MATRIX_3X3", 16, 17, 36);
    MATRIX_2X2 = new DataType("MATRIX_2X2", 17, 18, 16);
    RS_ELEMENT = new DataType("RS_ELEMENT", 18, 1000, 4);
    RS_TYPE = new DataType("RS_TYPE", 19, 1001, 4);
    RS_ALLOCATION = new DataType("RS_ALLOCATION", 20, 1002, 4);
    RS_SAMPLER = new DataType("RS_SAMPLER", 21, 1003, 4);
    RS_SCRIPT = new DataType("RS_SCRIPT", 22, 1004, 4);
    DataType[] arrayOfDataType = new DataType[23];
    arrayOfDataType[0] = NONE;
    arrayOfDataType[1] = FLOAT_32;
    arrayOfDataType[2] = FLOAT_64;
    arrayOfDataType[3] = SIGNED_8;
    arrayOfDataType[4] = SIGNED_16;
    arrayOfDataType[5] = SIGNED_32;
    arrayOfDataType[6] = SIGNED_64;
    arrayOfDataType[7] = UNSIGNED_8;
    arrayOfDataType[8] = UNSIGNED_16;
    arrayOfDataType[9] = UNSIGNED_32;
    arrayOfDataType[10] = UNSIGNED_64;
    arrayOfDataType[11] = BOOLEAN;
    arrayOfDataType[12] = UNSIGNED_5_6_5;
    arrayOfDataType[13] = UNSIGNED_5_5_5_1;
    arrayOfDataType[14] = UNSIGNED_4_4_4_4;
    arrayOfDataType[15] = MATRIX_4X4;
    arrayOfDataType[16] = MATRIX_3X3;
    arrayOfDataType[17] = MATRIX_2X2;
    arrayOfDataType[18] = RS_ELEMENT;
    arrayOfDataType[19] = RS_TYPE;
    arrayOfDataType[20] = RS_ALLOCATION;
    arrayOfDataType[21] = RS_SAMPLER;
    arrayOfDataType[22] = RS_SCRIPT;
    $VALUES = arrayOfDataType;
  }

  private Element$DataType(int paramInt1, int paramInt2)
  {
    this.mID = paramInt1;
    this.mSize = paramInt2;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Element.DataType
 * JD-Core Version:    0.6.0
 */