package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.kj;
import java.io.UnsupportedEncodingException;

public final class g
{
  static final byte[][] a;
  static final byte[][] b;
  static final byte[][] c;
  static final byte[][] d;
  static final byte[][] e;
  static final byte[][] f;
  static final byte[][] g;
  static final byte[][] h;
  public static boolean i;
  public static boolean j;
  private static final byte[][] k;
  private static final byte[][] l;
  private static int m;
  private static final Object n;

  static
  {
    byte[][] arrayOfByte1 = new byte[2][];
    arrayOfByte1[0] = a("0\004C0\003+ \003\002\001\002\002\t��ÂàFdJ00\r\006\t*H÷\r\001\001\004\005��0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\036\027\r080821231334Z\027\r360107231334Z0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��«V.��Ø;¢\b®\no\022N)Ú\021ò«VÐXâÌ©\023\003é·TÓrö@§\033\035Ë\023\tgbNFV§wj\031=²å¿·$©\036w\030\016jG¤;3Ù`w\0301EÌß{.XftÉáV[\037LjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\025Jd_qhÀ±¿Æ\022ê¿xWi»4ªyÜ~.¢vL®\007ØÁqT×î_d¥\032D¦\002ÂI\005AWÜ\002Í_\\\016Uûï\031ûã'ð±Q\026Å o\031ÑõÄÛÂÖ¹?hÌ)yÇ\016\030«k;ÕÛU*\016;LßXûíÁº5à\003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\013\024[j¡y\002\001\003£Ù0Ö0\035\006\003U\035\016\004\026\004\024Ç}Â!\027V%Óßkãä×¥0¦\006\003U\035#\0040\024Ç}Â!\027V%Óßkãä×¥¡x¤v0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android\t��ÂàFdJ00\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005��\003\001\001��mÒRÎï0,6\nªÎÏòÌ©\004»]z\026aø®F²B\004ÐÿJhÇí\032S\036ÄYZb<æ\007c±g)zzãW\022Ä\007ò\bðË\020)\022M{\020b\031ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\005»?âËD~s\020v­E³?`\tê\031Áaæ&Aª'\035ýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\013\020q§Ä@ðþ \034¶'ÊgCiÐ½/Ù\021ÿ\006Í¿,ú\020Ü\017:ãWbHÇïÆLqD\027B÷\005ÉÞW:õ[9\r×ý¹A1]_u0\021&ÿb\024\020Ài0");
    arrayOfByte1[1] = a("0\004¨0\003 \003\002\001\002\002\t��Õ¸l}ÓNõ0\r\006\t*H÷\r\001\001\004\005��01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\036\027\r080415233656Z\027\r350901233656Z01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��ÖÎ.\b\n¿â1MÑ³ÏÓ\030\\´=3ú\ftá½¶ÑÛ\023ö,\\9ßVøF=e¾ÀóÊBk\007Å¨íZ9ÁgçkÉ¹'K\013\"��\031©)\025årÅm*0\033£oÅü\021:ÖËt5¡m#«}úîáeäß\037\n½§\nQlN\005\021Ê|\fU\027[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\006¸Ì\030^±Uyîøm\b\013\035aÀù¯±ÂëÑ\007êE«Ûh£Ç^TÇlSÔ\013\022\035ç»Ó\016b\f\030áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\032¾^òÑ\030á¸®ó)ðf¿láD¬èm\034\033\017\002\001\003£ü0ù0\035\006\003U\035\016\004\026\004\024\034Å¾LC<a:\025°L¼\003òOà²0É\006\003U\035#\004Á0¾\024\034Å¾LC<a:\025°L¼\003òOà²¡¤01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com\t��Õ¸l}ÓNõ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005��\003\001\001��\031Ó\fñ\005ûx?L\r}Ò##=@zÏÎ��\b\035[×ÆéÖí k\016\021 \006Al¢D\023ÒkJ àõ$ÊÒ»\\nL¡\001j\025n¡ì]ÉZ^:\001��6ôHÕ\020¿.\036ag:;åm¯\013w±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\0319u3¯Øª\026\017BÂÐ\026>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\022þû¤Ä#ûOøÌIL\002ðõ\005\026\022ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\0035iÞ;¿ÿ|©Ú>\022Cö\013");
    a = arrayOfByte1;
    byte[][] arrayOfByte2 = new byte[2][];
    arrayOfByte2[0] = a("0\002R0\001»\002\004I4~0\r\006\t*H÷\r\001\001\004\005��0p1\0130\t\006\003U\004\006\023\002US1\0130\t\006\003U\004\b\023\002CA1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google, Inc1\0240\022\006\003U\004\013\023\013Google, Inc1\0200\016\006\003U\004\003\023\007Unknown0\036\027\r081202020758Z\027\r360419020758Z0p1\0130\t\006\003U\004\006\023\002US1\0130\t\006\003U\004\b\023\002CA1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google, Inc1\0240\022\006\003U\004\013\023\013Google, Inc1\0200\016\006\003U\004\003\023\007Unknown00\r\006\t*H÷\r\001\001\001\005��\003��0\002��H\003\031ù±G&8N\004SÑ\013¿Ç{%\004¤± |LlDº¼��­Æa\017¦¶«-¨\0163òîñk&£ö¸[úÊû¾³ôÉO~\"§àë§\\í=Ò)úseô\025\026AZ©Áa}ÕÎ\031ºè »Øü\027©´½&@Q!ªÛwÞ´��\0238\024\030.Å\"üX\r\002\003\001��\0010\r\006\t*H÷\r\001\001\004\005��\003��@fÖ1ÚCÝÐaÒ&às¹Ä¹øµä¾<¾P\036ß\034o©YÀÎ`\\OÒ¬m\034ÎÞ Glº±èò :ÿw\027­e-Ì\007\bÑ!m¨DWY&IàéÓÄ»Lõ¡±ÔüA¼¹XOdæ_A\r\005)ý[h\024\035\nÑÛ\021Ë*\r÷ê\f±-³¤");
    arrayOfByte2[1] = a("0\004¨0\003 \003\002\001\002\002\t��~OòÖµÞ0\r\006\t*H÷\r\001\001\005\005��01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\036\027\r100120010135Z\027\r370607010135Z01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��Ø(q|6Ñ\027\017ÔM\n{\017\007\021&è[¿ß3°4`��ZÌûe¥Û ²Cß`±¿\006ß\035\\\n3âÑcõ\023ß\035\"SAê<3y\"è\\\002ì4ÎÙL¸\007#¦#ÿK¯û´åïæw;>¢¾¸¼²\002gÏçQ\037.ù«uþ\036)Ï¼M\b:\037\022R��wsò\026[i{��£ Á:Ì0ò!cÁn=J²\0246LEÀC\0242p9ñÚ\t`ñ³ü\030¶V\020Æ\"_Ç\020+|o\023¤]$ãàÅNgã[g\b'\023ÒÖðWÝ4WÑÄþÝì:O?#\005\031§\n(64¬5£J½¡}Z\n\tûø\006\013\003j'x`cú\f7¹çò¡\016v¼w\002\001\003£ü0ù0\035\006\003U\035\016\004\026\004\024µÇù\022ox\r:ûÊess?õ\"k\02770É\006\003U\035#\004Á0¾\024µÇù\022ox\r:ûÊess?õ\"k\0277¡¤01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com\t��~OòÖµÞ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��L>§e}&æ»×\021\f\031ß\037¡\t}3\017iÞ¿ÊÛF£~å³\017»4{\034uU¼»<T\024F_y*\002ÐÛå¦Ga³yG«kÿ°ºÆ¢Á Íøbøw©g\rýo\006.@nÎ\030\006\f`Iü6'\021qåoË¡Ræ\005ÎÎY\037Äô©+3ºØ\031mwoU·Ð\032Ï1Ý×\fì·xv\006e\020ùI¥RJ11³ËeAÏ5B\016¼ÄR%Y?Bfi\005rfbO³ÏÛR\027\035\021\034n\003F\026øQ!\030Ð¢¦\023×ðÍ\021ÛÕ#ZT¥JÂQçÒ,Dj?î\024\022\020éDGK@c\007»&+OkÓU\034sQÿ¢`[\005â$×\025Øzö");
    b = arrayOfByte2;
    byte[][] arrayOfByte3 = new byte[1][];
    arrayOfByte3[0] = a("0\002§0\002e \003\002\001\002\002\004P\005|B0\013\006\007*HÎ8\004\003\005��071\0130\t\006\003U\004\006\023\002US1\0200\016\006\003U\004\n\023\007Android1\0260\024\006\003U\004\003\023\rAndroid Debug0\036\027\r120717145250Z\027\r220715145250Z071\0130\t\006\003U\004\006\023\002US1\0200\016\006\003U\004\n\023\007Android1\0260\024\006\003U\004\003\023\rAndroid Debug0\001·0\001,\006\007*HÎ8\004\0010\001\037\002��ýS\035u\022)RßJ.ìäçö\021·R<ïD��Ã\036?¶Q&iE]@\"QûY=Xú¿Åõº0öËUl×;\0354oòf`·kP¥¤è\004{\020\"ÂO»©×þ·Æ\033ø;WçÆ¨¦\025\017\004ûöÓÅ\036Ã\0025T\023Z\0262öuó®+a×*ïò\"\003\031ÑH\001Ç\002\025��`P\025#\013Ì²¹¢ë\013ðX\034õ\002��÷á Ö=ÞË¼«\\6¸W¹y¯»ú:êùWL\013=\007gQYWºÔYOæq\007\020´I\026q#èL(\026\023·Ï\t2È¦á<\026zT|(à£®\036+³¦un£\013ú!5bñûbz\001$;Ì¤ñ¾¨Q¨ßáZå\006f^{U%d\001L;þÏI*\003��\002jÑ\033×ÕfÒzô9À.Ah¬ýE´¾¼{\034wTi?\rB¤üá\0208BO¦Ñ0RNïöñ78c/¦7)þMF ¸feîðA\0279\001\003[\034j£\030\030\r0:¨ÌY#àjo«úuh<E;²\007w|òýçÏ±\02408\024ª\035÷´=[\"+W\006´0\013\006\007*HÎ8\004\003\005��\003/��0,\002\024\tÒÑ°G\002)µ¾Ò&aÑ\022òpÅæ\035\002\024gP\002\006§Pºx®Ç\027O\026\004ê¢÷");
    c = arrayOfByte3;
    byte[][] arrayOfByte4 = new byte[2][];
    arrayOfByte4[0] = a("0\004L0\0034 \003\002\001\002\002\t��¨Í\027É=¥Ù0\r\006\t*H÷\r\001\001\005\005��0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\036\027\r110324010653Z\027\r380809010653Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��Ã\017­Ù´\tj,XjZ5kú\002iXøÿ\f]úõI&ØpÞè!¥>\037[\027\017ÉbE£É§ËE'\005;ã^4óÒK\"ì\fRn&teàhuêb\037ù@ã4[ I\007ÌTt:ÍªÎeV_HºtÍA!ÍÈvß5\"ºÛ\t\\ Ù4Åj>\\9>åðà/àb\037\0375¨$%,o¦¶3§hk>Ha-\006©ÏoI¿ñ\035](þ\024¬WbCÝ)êý¹\rã&5\023©\005¬¯ ~Fu\nZ·¿w&/G°?Z<nm{Q4?iÇ÷%÷\013Ì\033JÕ%\013pZæè>â®7þW\001¼½²oîýÿö\017j[ßµ¶G\002\001\003£Ü0Ù0\035\006\003U\035\016\004\026\004\024\034ÎÎ\016êMÁ\022\037ÇQ_\r\n\fràÉm0©\006\003U\035#\004¡0\024\034ÎÎ\016êMÁ\022\037ÇQ_\r\n\fràÉm¡{¤y0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC\t��¨Í\027É=¥Ù0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��¤pÇ(áÓ\033\006Ù¯jçhµe\004lWkCrI1×]L¡\f2\025 Ó<Ïí*¦Tb#Lù¶ù\020ÌgkËÖÀgcWO»x3\022uÜ\\óº©\030×\005\037û¢­èó\003ÍèÙæ\004\037Û|*I²\"ÆÿB+ñUi¸^îí°J£\bsÛæKtøòÂöÄ\001$ª¨Ñx\r\030Q+T\nÝ(³éX\031q¤\027\rØhÏ_1äG\022²Â;µ\0207×ï¦å½³^,ëk°\"cl\027¥j¼zP%\013Òí{1UZ\030E.\0272\032\rRö?t-tÿyXj\\»¯q¨KÏtC\020éé'Y��¢=Ð\006`\f\"8Ù\013/³rßÛºu½.");
    arrayOfByte4[1] = a("0\004L0\0034 \003\002\001\002\002\t��Þv\004\035vPÀ0\r\006\t*H÷\r\001\001\005\005��0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\036\027\r110324010324Z\027\r380809010324Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��æÿ=ïé*¡\rqë\017¦@À6·âCîíh¦¤v=Ç¥*1u|ÚÆ\037å\020»sÇ\026ä��\001\004&[4ÎÎôÄ+ñá7Ð¨vð(\"»Áù½Õ×\023²ö©5£yÒË©ÉoÒÐx|\021ñë\031T\b¦ r³Klú\ná'gé��u0\026i¡\034ïFÎ÷Ç\004mÞ1û`(M\022\n°çÞ\035c?\007h}FQ\023ÿýÆ¼ |©\004¸¾\035 ª{NuoC`d¾\\®<hè»yBÍõ\026\007É0¢üÚe[uÐuº­\006ç9½\013¢\037@BÂÀ¨ZZ°ÐgÆÃìI! B¬c§å;Tle´`´ãæâ>\037wÏçöÞtK\032e\002\001\003£Ü0Ù0\035\006\003U\035\016\004\026\004\024¢èd°]\b\\4Û\n��P\021zì0©\006\003U\035#\004¡0\024¢èd°]\b\\4Û\n��P\021zì¡{¤y0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC\t��Þv\004\035vPÀ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��7q\fè|<Rê0ÆébÙKM_\022Â]&\025AýµU]\022Îó¸1,?]ö¨ªàL¹³\005ä'ý\035-\031áÒxñ<R\017\030!\002cØÔ½6QHØØº&Ø¹¿\tõý>»\016£ÂðÉ7o\036\037Êvó¦¤\005B\b\033u*z·Vé«DÚA«ÈáèøÂu§CûsæPqW\fËkzÝ!¹ÆäVá,\"=\\\007JßUö«Ú&-dê\nEîÍ´\022~uÇSÃÿ0ËÆxµ\034R\024rñ}¢\n\rÆ'J¢F44Á©¶\024ßi}õÊ\001ç¢\\}³û\005]eV\004°\0358«ºW³¡p>ÂçJÓ4");
    d = arrayOfByte4;
    byte[][] arrayOfByte5 = new byte[2][];
    arrayOfByte5[0] = a("0\005a0\003K\002\006\001DÓ0\013\006\t*H÷\r\001\001\0050v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0220\020\006\003U\004\003\023\tClockWork0\036\027\r140307220225Z\027\r380119031407Z0v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0220\020\006\003U\004\003\023\tClockWork0\002\"0\r\006\t*H÷\r\001\001\001\005��\003\002\017��0\002\n\002\002\001��º<9\013þYb¼ü<Æ'Z\025íÜÝ7:Uj\013âýC÷\030³\001Ò@'ãr\tÎýâ|&° Þ6}\032ßãN§®7óõà&rzN\b(;ïvøöC¼\025'6 H?É·«R<ó½{f-*'L��Øç\021è°&_í©uÜÈåB\023jbq.\013/9yQÛ$±W¡¿çÅkÎJ8\013%ú¹&c>¨\0048à¶\013¹~.ú\005<2)Ùao¤½!{7C\037ÍØí!§òðFà\034¼ZbãJ\025káZ\027ÿ\002\027dDÖ\023±\036×_\030î´ýäZã\034ä¯¤68¶,\\ÒÛ\n\001Ä2a(äÅ\031z¾¬ÌmÂè­¤B_\017Õ¥¥X$a¿x\021á.Î\016ê\006\003?T9íàqÿÄl òß¾##:dÁÎ\t­¡ËÎkö¼¢.JÀÉjluOì\030qØ{\020Á Þ`¼}wÞ0ÕN¸GÎk\022|\031\036§o\nFÁFó6¹4êºZ_\034\003d·RUD2Pýcªå{ë«à&?\t\bM\031D\006\f:Ù»ºyôÞ<+-7º³\rK¹\021ÜQià¯RôÓ=³òË\034R\002Rpa¿\001°BÐ~ä\021©ª 'ðDÚ(ÅÝØSW§\0369»Q³Wëor\030üÌ\027\030¦0gF1àU9\032zgòZ b\001Ö\"¸Ð\tÝ\021Õ\006¢\003\017$'®gØ\03347yy\002\003\001��\0010\013\006\t*H÷\r\001\001\005\003\002\001��¤Ä4aÈ5¥±\nÍ\001$7jÚ'C¬0\003Hg\013 +­ã?/º*\007d\003µ\013èqÊ*²¾½»Ä\006Û\t9AÉ\027j\016Fÿÿ��\026\026\004DnÜá0þ\020\036ã\005·~=©¢­4©Ò´Ú\033&ýZ[p\034Õlþédzä\024;¦|\002e±\024ò2¥ï\027ád¡I\027\0340½Z6«øóBÈã¯¼oICs\007}j\021×9\"\rZ×µ\031/\034þJr±¸Tuàé¾hrfe±+ôîÃ\"VTõáò+ëU¾fwÖ_\t-ù^þï\017ÇêÊ]\016¾\035A\004\037ç Ë20~9.\023ñ 9Ti0\002\027@-öÇ rçß8ºÃ×\"5oæTj|WßgÉ=+5T5ðù¡\023Î-ìÍm¡ÃKAì®Ö ëR0%Åà\004ì´Q¼EáHZÌ6¶I¯YLU\033\013É8ËÖ\032ÕgY ÷:eá©È¤Û¬\036ë\f)\t^ÞA\005{<®êN\026Å¹EKâY\021´¢\037?z¿Àgô\030.A¤ä4ð/í¯WrJU3WÚ_³ÍüùTÿØÉQwçu\004¦B¾\\Û á��eü|h\022í'³¨\004×¤ÍÙ\fÓìË\005¨È`ÐV N´\036\005ý9\\\037§{³\035¥$4^\n½N\001µ\006OêºBÓ-Ôg>ÏÀ\027\035&éÍ\\FïÐ");
    arrayOfByte5[1] = a("0\003¿0\002§ \003\002\001\002\002\t��ÚÃÙ\025sÓï0\r\006\t*H÷\r\001\001\005\005��0v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0220\020\006\003U\004\003\f\tClockWork0\036\027\r140307220118Z\027\r410723220118Z0v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0220\020\006\003U\004\003\f\tClockWork0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��Ü\035oK(í80\024²öÚÿÓ\035Þ{\036c\b@e\013X±e£j®¶,qS.\004E\t¯\037ºO\030dÃ§µÖSÌ��\025��\020áåfú7ªÿ\0306]®{JÝ±óÌGp¢>bþµrÁi1Z¯Nôê¥®\037ÍÖçåêÔ1\023tFF\f|(û2,\\\\z¨wÃp?à·~¶ n¬krê ­!\n°*\037ÜüvbttA©?<ê\026ô\"Áã2A2~ÂÉ÷01.\033ïî)\013E\0324,¬ï[\024rÖÙ~ùT(ÌÕï\004¸Äñõ\rÒBÕ]rXfP[^K\033\036Y­\035/ H\025g;ÆæC)ìÄêÔÛd©k1ÛÉ\007\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024G\020¤<³êø?«!b ��Î,z0\037\006\003U\035#\004\0300\026\024G\020¤<³êø?«!b ��Î,z0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��\0079b\013¢}*\017TC­\033`\034)Ù\001(êü?Ö(__bj>ðWæî²¬\\¢æ\005Ê=3õk��2ÄGæP\017%½\027Êù\0039@ÈîlÜµ;íä±òHçÐ çÊê¥2ÏÚþJ¥í@@ND÷[ïÒÊÛ5¸²\033xF^\027\"òzû+\013n\025DÄ«\fOe{\031×}SÉÏ¹î-OE¶Tà\022¼éäÂâÃÓQ\003Ø®M,ÁÈbxW®u?\035{\002£§\005xÆ\005ã\005\034l\035©I\032Î\023»Ð}}Ô&Q®¤G5\rë@^ò«óf®/ÊXÒö¿\035¿K\034Hà \001TßÏ\002%\022õ¡Ç\"s\035ãðGÖø");
    e = arrayOfByte5;
    byte[][] arrayOfByte6 = new byte[2][];
    arrayOfByte6[0] = a("0\003m0\002W\002\006\001=døÖ³0\013\006\t*H÷\r\001\001\0050|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0250\023\006\003U\004\n\023\fGoogle, Inc.1\0200\016\006\003U\004\013\023\007GoogleX1\0270\025\006\003U\004\003\023\016Glass Platform0\036\027\r130313181742Z\027\r380119031407Z0|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0250\023\006\003U\004\n\023\fGoogle, Inc.1\0200\016\006\003U\004\013\023\007GoogleX1\0270\025\006\003U\004\003\023\016Glass Platform0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��¡3¦Òi¯Ø6ã®Ü-¤­9¿øâ\031æH3´\030µ=5lì\024¸GF´\013ß\036B¡þôÑõ×B\fÀØ+çÚe\tÄ¯?ÛÎ/PTïìçA©éRZ\023#\003ÿÎ\025D¦9»ÊØt¯ ¼¼õ\026öYÚ7Á­/è£ÄZæ\036Ê¨W¢\005C9í¿oð@nÂA½\buqc).s©)\004ù=ìk½@c¼¥>y¸©Cp|¹üA;X\0170ðGE´õ7­§æ\032ÿüw\013NÓ<><ttb\036z­Ôw­\005ÜuL\r3\rÁXõæáõ¢`<Q&¬Bô\030Û xF)à\r§ë\0065ÙºGµE\fZ¢dØ/\002\003\001��\0010\013\006\t*H÷\r\001\001\005\003\001\001��è\025JôØôu°ã[ðÒR\006c\bLÏÑr%éKþÁJ\037¾7ErpÀÿVöVÁPéË¹Ùl\034;\013¡æ<êõÔæ«C*Ü±\023Wòc´èÍ®Ð¼p}ó\026í.©¶VxÔMþíä/°#¯cc±NSÄB²+ø«À¿i\005÷ó[(\022Kæc\035F\f9_5éu«FÞ\f?ß0Ï\017\007ÙE­}Ç¨d;ICà.&[\020tÕùKùXìÚúªoÅ¾¨Ìfý!»²nÏeéø.µ{gìÁéx·Ú'\027æÖ\035ç¦l!¿ÂY¶ÞÉ½zµòÓÛÅ\023\005ÚÚ¨ïâ)<¢\027:ì#\b`pNwÉÀ¦b0§");
    arrayOfByte6[1] = a("0\003É0\002± \003\002\001\002\002\t��Ãi ­ßtÇ0\r\006\t*H÷\r\001\001\005\005��0|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0250\023\006\003U\004\n\f\fGoogle, Inc.1\0200\016\006\003U\004\013\f\007GoogleX1\0270\025\006\003U\004\003\f\016Glass Platform0\036\027\r130226205628Z\027\r400714205628Z0|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0250\023\006\003U\004\n\f\fGoogle, Inc.1\0200\016\006\003U\004\013\f\007GoogleX1\0270\025\006\003U\004\003\f\016Glass Platform0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��¯ÊGêäÐ;\036\bà\tw¢ø\006Æ¢\027\035í§[pâ:¢ñ¹¿h¥/?v,¾Æ:\bÑBZÃ\033é2m\001\036|\006Î¡ÈJëp?Ð9*1\006²}\004^|áT\004K\"Ê¥\035[õù±$â\"ºsA-ÔY0h,Fg1°Y¯¦¤èÝ?^µ@øº\021](G@)×\0371å»°ê^0 äuµ¤ý4\027\nÔ.ØPë9T,+éµm5þ¶²¨4iúKæ+È¤|è��\003l®ðõ3sÉX\025¸ÊÙs[¿·��eh¾mæw\020-E¿¶9z:\037\001%¸\025\005\005·«ÝÂ`\037~ñXÕ(á­;pmhE\017%:\023íyÀ\002l¨\023\021ÕËß·\002\001\003£P0N0\035\006\003U\035\016\004\026\004\024óSB\037\017Í{#j_µ\037fWc\031Ð{0\037\006\003U\035#\004\0300\026\024óSB\037\017Í{#j_µ\037fWc\031Ð{0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��©X±/\007ï\024}CÅ=ÂÉèá\001¥b\bfF¼\004·\035÷yxÜ!/ü|\003ú¯Y%;èõ2Â_]uºæïº´XRp(hk\001B'¥A·C§³/4Ñ[Yô \025X%ý¼ì>ÒtÎìÇ\001Ë«[Ug\"3wn÷ä´â\001R\016FÕEI\\\024Ày­}\037ýã¢±Ê\033Q[ +7[÷/6\017ó-­`S:Ú×Å~#dRE¥ºÊÊBTý!³d!_\004vòéI\031÷W \023Xv\nF!î\003UÙ»@h\017Úó±¨f\004+Ë@3àw,Öãª\036 Æñ\002\004úå[£áÙßëÔ@Uü\007¨æ­;Ô\0217ö/_f£÷\030$õO({Úø?");
    f = arrayOfByte6;
    byte[][] arrayOfByte7 = new byte[2][];
    arrayOfByte7[0] = a("0\003Á0\002© \003\002\001\002\002\t��é\005DY+P0\r\006\t*H÷\r\001\001\005\005��0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\036\027\r140527043400Z\027\r411012043400Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��Ðuk\027*HI*Õî>r~ë`\"¬Ø\b»W\fECÚCÄaåçb\034\005\n]ç¢½\017\f\002`ÿâr]ØHH$\032\006îf¬+ýáÞ\r\tEWËÇ\"ne¿)\035\017å-¨ÑRg7ìj\016.7ù³ÎÓÓÙå°\tªYÛ!VÈÊ#u´\034fö9\n-\016\016IÁxt\tÀÙ%_ËÅY\022\033Oòâ-±ât\032��ÚIYôan­\016\022mÀKeðï\017¼BzÔ2ÏOïM:d`ÊÄ÷rXê-è½@¿\007ó?`]}Wf¾z!òJ',ªX¥9\\Íÿ&}\013Ôò~D-É¼ÄJ\024dW§:J½!_w\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024³ÌD*Ûè6xð[4q4¬c\036` 0\037\006\003U\035#\004\0300\026\024³ÌD*Ûè6xð[4q4¬c\036` 0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��+ù\033qéèî\002[Ué<â¨R\027%¡ª\031\020Bï­6¸) É\033'\037ãûiD3\023gú¦&¤â(\035ì¥ßÌÝ\003ÆBªñ{tÜ&ü^P½OLââ\033kûìë\033ÝpåÿÈ[þ²A\031D'3ôÐÚMc<^¾å\n\037\024?E£ÏÎ@®ÐaÕ+\007¹b¼fÑ_>ÔùÖÆH²\0218ÊúþvôÜ»å\"¢l.Õ\b¦·\táW*P¯SÑ\006:\0271½\027i[GÙ¡4!g.\fp\034ÊÎ¶\026g5.IaÁ\f×JD6y+6N5³\020 _+\024²hsbK7èi:\034´í3oVáØ zé\002³>9\016Q²Ê4@\"");
    arrayOfByte7[1] = a("0\003Á0\002© \003\002\001\002\002\t��ÐTãÎÛÎ\0040\r\006\t*H÷\r\001\001\005\005��0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\036\027\r140603192622Z\027\r411019192622Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��µ\037{°ìÎp4cÎÓ\0354r¬¶©£õ?ßÐæ#ð={4]\037õ\"Øízeå3´â>ñ@k}Õ\024h\035>vÎÐe\005óM#\021_��WG6I-hÏ|¶Ø|§uÂeÞ!\037­pg\bø¯1,í3.Çgb\bà/{í{4f¡2\005tu²gm¸q\034và;Ì7¤c\005(#ä_*rN8'\020&\007oTÂéÈ¹ÿ#Az/Èµ s®\t_\036«ÜJÎzó%\003s\003d\022Ôñó,(Lâ¾ý_öèÃ\021äÎ\033TgHûý¡ãß0¦ø,ä¥ËÕ*?ò\025s:°ÈKz\030ïQlÐá¯°\017\b­\037\006ÿ2é;©\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024§L:À:o°\núúÉ×@(\\ «\0200\037\006\003U\035#\004\0300\026\024§L:À:o°\núúÉ×@(\\ «\0200\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001�� >dBCQ¼>Y_Ôà¥\n=-à\"s7��KÌ;7|yê²¬\031íÎ]$<W2¤sóPh9��þÖd\006Î\bÈ\023&Ò\023ÔûÃ%ßkøê»¹\033<.a°ÚtFS`sj\037H-Ét;â÷a\024\030èCY]\032\032¶¡-ÐvÆ}L#ª\017×°ñ\bã;÷\037En·RÃº\007öÐ{¤Wß\001t²\b§¡^ÉD#n[ÔØ7\001Ý_\f  r8bø\002aÈ4r9¤\013Í\020\017\f(âÏ*~º#%o_¬$f#\017§Ï}ÆâDD\020\017Ý¾)Áí|G\0200ïV\006ý\005Ç`\027¥¯ð2Sh¯\001£ ÷\017O\r��+E\026¨4ÚÌ\tÍq6");
    g = arrayOfByte7;
    byte[][] arrayOfByte8 = new byte[2][];
    arrayOfByte8[0] = a("0\003µ0\002 \003\002\001\002\002\t��å×\027Ît¡0\r\006\t*H÷\r\001\001\005\005��0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\036\027\r140529162639Z\027\r411014162639Z0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��¾¡ÀW\037¸\f]xw#T\021;\003b\032ÖrV&-.-hI°\021ÑùK7ký\027üÞ7¤ÿ\021+*?/Rn\013ïæÅÌÃBátÑ2Ã$_{ó\030U'ï²-µ\016¿yËò3ÝÚ1K\004»Íò|è/75ì$e\\Ô+/5®JRÍ¢îtÒ+ÛR\023SègZÉ¸ýR®\031ªªo^ë_Ùºs³b &©hÔÂnW'f\017p®A\031/v;=pUV1*ý\037\n`Öþ\021úR¦\022: Î3A$ýÆ\n~*z6yÛ£=ø\"´\007mÊº»«ÎÛ\034&Ë\001ëÏÂ\023fð\0330\016µHÊñ\005xÆ\r:kihR\\x<\003Ý\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024Â¸ç\001Að\nà\013\\\006?Mnú\007p¦0\037\006\003U\035#\004\0300\026\024Â¸ç\001Að\nà\013\\\006?Mnú\007p¦0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��H¡LÏsf¦\005óS\003,P\020$Ze%\020Å)@ìÛ¾_Ü} Ý4­Ò\033ÏVðÂ-Ã9þI\023:ûÐÂ!£í_rEå!9¼\022VwòI2í34·|«­\025F\022tN¼\030Ý&Cóc#UHÌ^Á?JqxP?c÷\0176C@ùc7]ÈÉ=úzO'ÂØZîý¬¢¹Ï\013q¤\rrþAÌ\004d¯,1\bì|\006Uõ«Ò«¢UáÍY\"³v·Kº\033\005[Ç×¶ó' §Òõ ¼\003çµn+Û'¦ð)qG\025$ éÑDÀþåÎ¢)ß\b-ù\0207p��uî<èÀÎ\\\003¹5Óý\025v\005Fl");
    arrayOfByte8[1] = a("0\003µ0\002 \003\002\001\002\002\t��åo\t\033\0370\r\006\t*H÷\r\001\001\005\005��0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\036\027\r140529162612Z\027\r411014162612Z0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��Ä_Uº4\\Ñ@_IÚÏ96Ör\017Ë6áMÚÿ��ß[rÂÑN­ÌdÑþÈ/ðLÂ®Öæ¤ÑKc\037ØÖ\030]à\020A\024\036w\tUñq­«*­ÉV94O+úzQ×ëÜ.Îñh~¶\036\001ÀñI?\003Tj\032­­$\\÷22ZÿZ·À\033\t\001a~\022\036\025»Æ{(WiËZ6+6¦2s§\001y ë@QÅ¦@ùvTOo\025Á»À\\®r&.t#2¡ßK°ð;àU·6TÛ?óú)°ÔÍZË=§Äø~jü\033Yy\t·\025Å\"eÖÃh,æ\025E­ê)å­ÎçWà¯\002õx\r©\030Z9\030-#G\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024à»øÁWûã»ùfÉä;¤Ü\004'\nõH0\037\006\003U\035#\004\0300\026\024à»øÁWûã»ùfÉä;¤Ü\004'\nõH0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��îÅô/jêâ6\035ðÇÕ\bQér\026eàF��ÅøÌ×^64Ì õÅÓ2»gÖà­\025k\003oímÒ[\036h¿7åiå[vN\f\031\027¾\035Ï¿|\t\016Q¿¯\006\004¬\031Ï×@åøväj'½ü¾¦·®\036 Up\035\"0\005ì ½Àþz\021a¤Û}Ñ\027ë\024th¾Ø(¬JbåîW·5Â\022¿ò^tòIJ\nZÖ8Y½\feóÍÒDN±*\024Å¸\n*Ý×{\006ÓqÌ·Î¢«S:\037z[(S4é\020 ó²EÜkÊ¦Ä,Ë(;ìá/1Û\024t%KPIÙ\027yÍ#}ò¦*b£\bÜ?Ñ7$gÍ`q");
    h = arrayOfByte8;
    byte[][][] arrayOfByte = new byte[8][][];
    arrayOfByte[0] = a;
    arrayOfByte[1] = b;
    arrayOfByte[2] = c;
    arrayOfByte[3] = d;
    arrayOfByte[4] = e;
    arrayOfByte[5] = f;
    arrayOfByte[6] = g;
    arrayOfByte[7] = h;
    k = a(arrayOfByte);
    byte[][] arrayOfByte9 = new byte[7][];
    arrayOfByte9[0] = a[0];
    arrayOfByte9[1] = b[0];
    arrayOfByte9[2] = d[0];
    arrayOfByte9[3] = e[0];
    arrayOfByte9[4] = f[0];
    arrayOfByte9[5] = g[0];
    arrayOfByte9[6] = h[0];
    l = arrayOfByte9;
    i = false;
    j = false;
    m = -1;
    n = new Object();
  }

  // ERROR //
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: bipush 9
    //   2: istore_1
    //   3: aload_0
    //   4: invokevirtual 105	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 109	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   12: getstatic 114	com/google/android/gms/b:common_google_play_services_unknown_issue	I
    //   15: invokevirtual 120	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   18: pop
    //   19: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   22: ldc2_w 127
    //   25: lcmp
    //   26: ifge +20 -> 46
    //   29: bipush 12
    //   31: istore_1
    //   32: iload_1
    //   33: ireturn
    //   34: astore_3
    //   35: ldc 130
    //   37: ldc 132
    //   39: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: goto -24 -> 19
    //   46: aload_0
    //   47: invokestatic 140	com/google/android/gms/common/g:d	(Landroid/content/Context;)V
    //   50: aload_2
    //   51: ldc 142
    //   53: bipush 64
    //   55: invokevirtual 148	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   58: astore 7
    //   60: aload 7
    //   62: getfield 153	android/content/pm/PackageInfo:versionCode	I
    //   65: invokestatic 158	com/google/android/gms/internal/lp:c	(I)Z
    //   68: ifeq +272 -> 340
    //   71: aload_2
    //   72: aload_0
    //   73: invokevirtual 162	android/content/Context:getPackageName	()Ljava/lang/String;
    //   76: bipush 64
    //   78: invokevirtual 148	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   81: astore 23
    //   83: invokestatic 165	com/google/android/gms/common/g:a	()Z
    //   86: ifne +147 -> 233
    //   89: iconst_2
    //   90: anewarray 26	[B
    //   93: astore 28
    //   95: aload 28
    //   97: iconst_0
    //   98: getstatic 35	com/google/android/gms/common/g:a	[[B
    //   101: iconst_1
    //   102: aaload
    //   103: aastore
    //   104: aload 28
    //   106: iconst_1
    //   107: getstatic 63	com/google/android/gms/common/g:f	[[B
    //   110: iconst_1
    //   111: aaload
    //   112: aastore
    //   113: aload 7
    //   115: aload 28
    //   117: invokestatic 168	com/google/android/gms/common/g:a	(Landroid/content/pm/PackageInfo;[[B)[B
    //   120: ifnonnull +42 -> 162
    //   123: ldc 130
    //   125: ldc 170
    //   127: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: goto -99 -> 32
    //   134: astore 5
    //   136: ldc 130
    //   138: ldc 175
    //   140: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   143: pop
    //   144: iconst_1
    //   145: istore_1
    //   146: goto -114 -> 32
    //   149: astore 21
    //   151: ldc 130
    //   153: ldc 177
    //   155: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: goto -127 -> 32
    //   162: iconst_2
    //   163: anewarray 26	[B
    //   166: astore 29
    //   168: aload 29
    //   170: iconst_0
    //   171: getstatic 35	com/google/android/gms/common/g:a	[[B
    //   174: iconst_1
    //   175: aaload
    //   176: aastore
    //   177: aload 29
    //   179: iconst_1
    //   180: getstatic 63	com/google/android/gms/common/g:f	[[B
    //   183: iconst_1
    //   184: aaload
    //   185: aastore
    //   186: aload 23
    //   188: aload 29
    //   190: invokestatic 168	com/google/android/gms/common/g:a	(Landroid/content/pm/PackageInfo;[[B)[B
    //   193: ifnonnull +258 -> 451
    //   196: ldc 130
    //   198: new 179	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   205: ldc 182
    //   207: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 23
    //   212: getfield 190	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   215: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc 192
    //   220: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   229: pop
    //   230: goto -198 -> 32
    //   233: iconst_2
    //   234: anewarray 26	[B
    //   237: astore 24
    //   239: aload 24
    //   241: iconst_0
    //   242: getstatic 35	com/google/android/gms/common/g:a	[[B
    //   245: iconst_0
    //   246: aaload
    //   247: aastore
    //   248: aload 24
    //   250: iconst_1
    //   251: getstatic 63	com/google/android/gms/common/g:f	[[B
    //   254: iconst_0
    //   255: aaload
    //   256: aastore
    //   257: aload 7
    //   259: aload 24
    //   261: invokestatic 168	com/google/android/gms/common/g:a	(Landroid/content/pm/PackageInfo;[[B)[B
    //   264: ifnonnull +14 -> 278
    //   267: ldc 130
    //   269: ldc 197
    //   271: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   274: pop
    //   275: goto -243 -> 32
    //   278: iconst_1
    //   279: anewarray 26	[B
    //   282: astore 25
    //   284: aload 25
    //   286: iconst_0
    //   287: getstatic 63	com/google/android/gms/common/g:f	[[B
    //   290: iconst_0
    //   291: aaload
    //   292: aastore
    //   293: aload 23
    //   295: aload 25
    //   297: invokestatic 168	com/google/android/gms/common/g:a	(Landroid/content/pm/PackageInfo;[[B)[B
    //   300: ifnonnull +151 -> 451
    //   303: ldc 130
    //   305: new 179	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   312: ldc 182
    //   314: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload 23
    //   319: getfield 190	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   322: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc 199
    //   327: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   336: pop
    //   337: goto -305 -> 32
    //   340: aload_0
    //   341: invokestatic 202	com/google/android/gms/internal/lp:a	(Landroid/content/Context;)Z
    //   344: ifeq +25 -> 369
    //   347: aload 7
    //   349: getstatic 35	com/google/android/gms/common/g:a	[[B
    //   352: invokestatic 168	com/google/android/gms/common/g:a	(Landroid/content/pm/PackageInfo;[[B)[B
    //   355: ifnonnull +96 -> 451
    //   358: ldc 130
    //   360: ldc 204
    //   362: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   365: pop
    //   366: goto -334 -> 32
    //   369: aload_2
    //   370: ldc 206
    //   372: bipush 64
    //   374: invokevirtual 148	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   377: astore 10
    //   379: aload 10
    //   381: getstatic 35	com/google/android/gms/common/g:a	[[B
    //   384: invokestatic 168	com/google/android/gms/common/g:a	(Landroid/content/pm/PackageInfo;[[B)[B
    //   387: astore 11
    //   389: aload 11
    //   391: ifnonnull +27 -> 418
    //   394: ldc 130
    //   396: ldc 208
    //   398: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   401: pop
    //   402: goto -370 -> 32
    //   405: astore 8
    //   407: ldc 130
    //   409: ldc 210
    //   411: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   414: pop
    //   415: goto -383 -> 32
    //   418: iconst_1
    //   419: anewarray 26	[B
    //   422: astore 12
    //   424: aload 12
    //   426: iconst_0
    //   427: aload 11
    //   429: aastore
    //   430: aload 7
    //   432: aload 12
    //   434: invokestatic 168	com/google/android/gms/common/g:a	(Landroid/content/pm/PackageInfo;[[B)[B
    //   437: ifnonnull +14 -> 451
    //   440: ldc 130
    //   442: ldc 204
    //   444: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   447: pop
    //   448: goto -416 -> 32
    //   451: ldc 211
    //   453: invokestatic 214	com/google/android/gms/internal/lp:a	(I)I
    //   456: istore 13
    //   458: aload 7
    //   460: getfield 153	android/content/pm/PackageInfo:versionCode	I
    //   463: invokestatic 214	com/google/android/gms/internal/lp:a	(I)I
    //   466: iload 13
    //   468: if_icmpge +37 -> 505
    //   471: ldc 130
    //   473: new 179	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   480: ldc 216
    //   482: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 7
    //   487: getfield 153	android/content/pm/PackageInfo:versionCode	I
    //   490: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   499: pop
    //   500: iconst_2
    //   501: istore_1
    //   502: goto -470 -> 32
    //   505: aload_2
    //   506: ldc 142
    //   508: iconst_0
    //   509: invokevirtual 223	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   512: astore 16
    //   514: aload 16
    //   516: getfield 228	android/content/pm/ApplicationInfo:enabled	Z
    //   519: ifne +28 -> 547
    //   522: iconst_3
    //   523: istore_1
    //   524: goto -492 -> 32
    //   527: astore 14
    //   529: ldc 130
    //   531: ldc 230
    //   533: invokestatic 233	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/String;)I
    //   536: pop
    //   537: aload 14
    //   539: invokevirtual 236	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   542: iconst_1
    //   543: istore_1
    //   544: goto -512 -> 32
    //   547: iconst_0
    //   548: istore_1
    //   549: goto -517 -> 32
    //
    // Exception table:
    //   from	to	target	type
    //   8	19	34	java/lang/Throwable
    //   50	60	134	android/content/pm/PackageManager$NameNotFoundException
    //   71	83	149	android/content/pm/PackageManager$NameNotFoundException
    //   369	379	405	android/content/pm/PackageManager$NameNotFoundException
    //   505	514	527	android/content/pm/PackageManager$NameNotFoundException
  }

  public static Intent a(int paramInt)
  {
    Intent localIntent;
    switch (paramInt)
    {
    default:
      localIntent = null;
    case 1:
    case 2:
    case 3:
    case 12:
    }
    while (true)
    {
      return localIntent;
      localIntent = kj.b("com.google.android.gms");
      continue;
      localIntent = kj.a("com.google.android.gms");
      continue;
      localIntent = kj.a();
    }
  }

  @Deprecated
  public static Intent a(Context paramContext, int paramInt)
  {
    return a(paramInt);
  }

  public static boolean a()
  {
    if (i);
    for (boolean bool = j; ; bool = "user".equals(Build.TYPE))
      return bool;
  }

  // ERROR //
  private static byte[] a(android.content.pm.PackageInfo paramPackageInfo, byte[][] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 272
    //   3: invokestatic 278	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   6: astore 5
    //   8: aload_0
    //   9: getfield 282	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   12: arraylength
    //   13: iconst_1
    //   14: if_icmpeq +34 -> 48
    //   17: ldc 130
    //   19: ldc_w 284
    //   22: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   25: pop
    //   26: aconst_null
    //   27: astore 4
    //   29: aload 4
    //   31: areturn
    //   32: astore_2
    //   33: ldc 130
    //   35: ldc_w 286
    //   38: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: aconst_null
    //   43: astore 4
    //   45: goto -16 -> 29
    //   48: aload_0
    //   49: getfield 282	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   52: iconst_0
    //   53: aaload
    //   54: invokevirtual 292	android/content/pm/Signature:toByteArray	()[B
    //   57: astore 6
    //   59: new 294	java/io/ByteArrayInputStream
    //   62: dup
    //   63: aload 6
    //   65: invokespecial 297	java/io/ByteArrayInputStream:<init>	([B)V
    //   68: astore 7
    //   70: aload 5
    //   72: aload 7
    //   74: invokevirtual 301	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   77: checkcast 303	java/security/cert/X509Certificate
    //   80: astore 10
    //   82: aload 10
    //   84: invokevirtual 306	java/security/cert/X509Certificate:checkValidity	()V
    //   87: iconst_0
    //   88: istore 15
    //   90: iload 15
    //   92: aload_1
    //   93: arraylength
    //   94: if_icmpge +83 -> 177
    //   97: aload_1
    //   98: iload 15
    //   100: aaload
    //   101: astore 17
    //   103: aload 17
    //   105: aload 6
    //   107: invokestatic 311	java/util/Arrays:equals	([B[B)Z
    //   110: ifeq +61 -> 171
    //   113: aload 17
    //   115: astore 4
    //   117: goto -88 -> 29
    //   120: astore 8
    //   122: ldc 130
    //   124: ldc_w 313
    //   127: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aconst_null
    //   132: astore 4
    //   134: goto -105 -> 29
    //   137: astore 13
    //   139: ldc 130
    //   141: ldc_w 315
    //   144: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: aconst_null
    //   149: astore 4
    //   151: goto -122 -> 29
    //   154: astore 11
    //   156: ldc 130
    //   158: ldc_w 317
    //   161: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   164: pop
    //   165: aconst_null
    //   166: astore 4
    //   168: goto -139 -> 29
    //   171: iinc 15 1
    //   174: goto -84 -> 90
    //   177: ldc 130
    //   179: iconst_2
    //   180: invokestatic 321	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   183: ifeq +34 -> 217
    //   186: ldc 130
    //   188: new 179	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 323
    //   198: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 6
    //   203: iconst_0
    //   204: invokestatic 329	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   207: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 332	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   216: pop
    //   217: aconst_null
    //   218: astore 4
    //   220: goto -191 -> 29
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	32	java/security/cert/CertificateException
    //   70	82	120	java/security/cert/CertificateException
    //   82	87	137	java/security/cert/CertificateExpiredException
    //   82	87	154	java/security/cert/CertificateNotYetValidException
  }

  private static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new AssertionError(localUnsupportedEncodingException);
  }

  private static byte[][] a(byte[][][] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    int i2 = 0;
    int i3 = 0;
    while (i2 < i1)
    {
      i3 += paramArrayOfByte[i2].length;
      i2++;
    }
    byte[][] arrayOfByte = new byte[i3][];
    int i4 = paramArrayOfByte.length;
    int i5 = 0;
    int i7;
    for (int i6 = 0; i5 < i4; i6 = i7)
    {
      byte[][] arrayOfByte1 = paramArrayOfByte[i5];
      i7 = i6;
      int i8 = 0;
      while (i8 < arrayOfByte1.length)
      {
        int i9 = i7 + 1;
        arrayOfByte[i7] = arrayOfByte1[i8];
        i8++;
        i7 = i9;
      }
      i5++;
    }
    return arrayOfByte;
  }

  public static void b(Context paramContext)
  {
    int i1 = a(paramContext);
    if (i1 != 0)
    {
      Intent localIntent = a(paramContext, i1);
      Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + i1);
      if (localIntent == null)
        throw new e(i1);
      throw new f(i1, "Google Play Services not available", localIntent);
    }
  }

  public static Context c(Context paramContext)
  {
    try
    {
      Context localContext2 = paramContext.createPackageContext("com.google.android.gms", 3);
      localContext1 = localContext2;
      return localContext1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        Context localContext1 = null;
    }
  }

  private static void d(Context paramContext)
  {
    Object localObject = null;
    int i1;
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      localObject = localApplicationInfo;
      Bundle localBundle = localObject.metaData;
      if (localBundle == null)
        break label123;
      i1 = localBundle.getInt("com.google.android.gms.version");
      if (i1 == 5089000)
        return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", localNameNotFoundException);
    }
    throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 5089000 but found " + i1 + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
    label123: throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.g
 * JD-Core Version:    0.6.0
 */