package com.stericson.RootTools;

import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Pattern;

class InternalVariables
{
  protected static final String PS_REGEX = "^\\S+\\s+([0-9]+).*$";
  protected static String TAG = "RootTools v1.7";
  protected static boolean accessGiven = false;
  protected static String busyboxVersion;
  protected static String getSpaceFor;
  protected static ArrayList<Mount> mounts;
  protected static boolean nativeToolsReady = false;
  protected static Set<String> path;
  protected static Pattern psPattern = Pattern.compile("^\\S+\\s+([0-9]+).*$");
  protected static String[] space;
  protected static ArrayList<Symlink> symlinks;
  protected static int timeout = 10000;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.InternalVariables
 * JD-Core Version:    0.6.2
 */