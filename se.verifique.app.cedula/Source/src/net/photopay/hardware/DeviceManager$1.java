package net.photopay.hardware;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class DeviceManager$1
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    if (Pattern.matches("cpu[0-9]", paramFile.getName()));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.DeviceManager.1
 * JD-Core Version:    0.6.0
 */