package net.photopay.barcode;

public enum ElementType
{
  static
  {
    BYTE_DATA = new ElementType("BYTE_DATA", 1);
    ElementType[] arrayOfElementType = new ElementType[2];
    arrayOfElementType[0] = TEXT_DATA;
    arrayOfElementType[1] = BYTE_DATA;
    $VALUES = arrayOfElementType;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.barcode.ElementType
 * JD-Core Version:    0.6.0
 */