package io.card.payment;

class DetectionInfo
{
  public boolean bottomEdge;
  public CreditCard detectedCard;
  public float focusScore;
  public boolean leftEdge;
  public int[] prediction = new int[16];
  public boolean rightEdge;
  public boolean topEdge;

  public DetectionInfo()
  {
    this.prediction[0] = -1;
    this.prediction[15] = -1;
    this.detectedCard = new CreditCard();
  }

  final boolean a()
  {
    int i = this.prediction[0];
    boolean bool = false;
    if (i >= 0)
      bool = true;
    return bool;
  }

  final boolean a(DetectionInfo paramDetectionInfo)
  {
    return (paramDetectionInfo.topEdge == this.topEdge) && (paramDetectionInfo.bottomEdge == this.bottomEdge) && (paramDetectionInfo.leftEdge == this.leftEdge) && (paramDetectionInfo.rightEdge == this.rightEdge);
  }

  final CreditCard b()
  {
    String str = new String();
    for (int i = 0; (i < 16) && (this.prediction[i] >= 0) && (this.prediction[i] < 10); i++)
      str = str + String.valueOf(this.prediction[i]);
    this.detectedCard.cardNumber = str;
    return this.detectedCard;
  }

  final int c()
  {
    int i = 1;
    int j;
    int k;
    label20: int n;
    label35: int i1;
    if (this.topEdge)
    {
      j = i;
      if (!this.bottomEdge)
        break label59;
      k = i;
      int m = k + j;
      if (!this.leftEdge)
        break label64;
      n = i;
      i1 = n + m;
      if (!this.rightEdge)
        break label70;
    }
    while (true)
    {
      return i1 + i;
      j = 0;
      break;
      label59: k = 0;
      break label20;
      label64: n = 0;
      break label35;
      label70: i = 0;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.DetectionInfo
 * JD-Core Version:    0.6.2
 */