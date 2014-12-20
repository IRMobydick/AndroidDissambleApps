package a.a.a;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class cn
{
  public static final String a = a();
  private static ResourceBundle b;
  private String c;
  private dn d;

  static
  {
    try
    {
      b = ResourceBundle.getBundle("assets/TidyMessages", Locale.ENGLISH);
      return;
    }
    catch (MissingResourceException localMissingResourceException)
    {
    }
    throw new Error(localMissingResourceException.toString());
  }

  private static String a()
  {
    return "2009-12-01";
  }

  private String a(ay paramay)
  {
    String str;
    if (paramay != null)
      if (paramay.h == 5)
        str = "<" + paramay.n + ">";
    while (true)
    {
      return str;
      if (paramay.h == 6)
      {
        str = "</" + paramay.n + ">";
        continue;
      }
      if (paramay.h == 1)
      {
        str = "<!DOCTYPE>";
        continue;
      }
      if (paramay.h == 4)
      {
        str = "plain text";
        continue;
      }
      str = paramay.n;
      continue;
      str = "";
    }
  }

  private void a(PrintWriter paramPrintWriter, String paramString, Object[] paramArrayOfObject, dm paramdm)
  {
    try
    {
      String str = a(-1, null, paramString, paramArrayOfObject, paramdm);
      paramPrintWriter.println(str);
      return;
    }
    catch (MissingResourceException localMissingResourceException)
    {
      while (true)
        paramPrintWriter.println(localMissingResourceException.toString());
    }
  }

  private String b(aw paramaw)
  {
    Object localObject;
    try
    {
      if (paramaw.F.Y)
      {
        String str3 = b.getString("emacs_format");
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = this.c;
        arrayOfObject2[1] = new Integer(paramaw.i);
        arrayOfObject2[2] = new Integer(paramaw.j);
        localObject = MessageFormat.format(str3, arrayOfObject2) + " ";
      }
      else
      {
        String str1 = b.getString("line_column");
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = new Integer(paramaw.i);
        arrayOfObject1[1] = new Integer(paramaw.j);
        String str2 = MessageFormat.format(str1, arrayOfObject1);
        localObject = str2;
      }
    }
    catch (MissingResourceException localMissingResourceException)
    {
      paramaw.b.println(localMissingResourceException.toString());
      localObject = "";
    }
    return (String)localObject;
  }

  private void b(int paramInt, aw paramaw, String paramString, Object[] paramArrayOfObject, dm paramdm)
  {
    try
    {
      String str = a(paramInt, paramaw, paramString, paramArrayOfObject, paramdm);
      paramaw.b.println(str);
      return;
    }
    catch (MissingResourceException localMissingResourceException)
    {
      while (true)
        paramaw.b.println(localMissingResourceException.toString());
    }
  }

  protected String a(int paramInt, aw paramaw, String paramString, Object[] paramArrayOfObject, dm paramdm)
  {
    int i = 0;
    String str1 = b.getString(paramString);
    String str2;
    String str3;
    if ((paramaw != null) && (paramdm != dm.a))
    {
      str2 = b(paramaw);
      if (paramdm != dm.d)
        break label152;
      str3 = b.getString("error");
      label49: if (paramArrayOfObject != null)
        str1 = MessageFormat.format(str1, paramArrayOfObject);
      if (this.d != null)
        if (paramaw == null)
          break label180;
    }
    label152: label180: for (int j = paramaw.i; ; j = 0)
    {
      if (paramaw != null)
        i = paramaw.j;
      dl localdl = new dl(paramInt, j, i, paramdm, str1);
      this.d.a(localdl);
      return str2 + str3 + str1;
      str2 = "";
      break;
      if (paramdm == dm.c)
      {
        str3 = b.getString("warning");
        break label49;
      }
      str3 = "";
      break label49;
    }
  }

  public void a(aw paramaw)
  {
    if (((0x30 & paramaw.c) != 0) && (((0x10 & paramaw.c) == 0) || ((0x20 & paramaw.c) != 0)))
      paramaw.c = (0xFFFFFFCF & paramaw.c);
    int j;
    if (paramaw.e != 0)
      if ((0x4C & paramaw.e) != 0)
      {
        if (!"Cp1252".equals(paramaw.F.b()))
          break label533;
        j = 1;
      }
    while (true)
    {
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = new Integer(j);
      b(76, paramaw, "vendor_specific_chars_summary", arrayOfObject3, dm.a);
      int i;
      if (((0x4D & paramaw.e) != 0) || ((0x52 & paramaw.e) != 0))
      {
        if (!"Cp1252".equals(paramaw.F.b()))
          break label554;
        i = 1;
      }
      while (true)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = new Integer(i);
        b(77, paramaw, "invalid_sgml_chars_summary", arrayOfObject2, dm.a);
        if ((0x4E & paramaw.e) != 0)
          b(78, paramaw, "invalid_utf8_summary", null, dm.a);
        if ((0x4F & paramaw.e) != 0)
          b(79, paramaw, "invalid_utf16_summary", null, dm.a);
        if ((0x51 & paramaw.e) != 0)
          b(81, paramaw, "invaliduri_summary", null, dm.a);
        if (paramaw.f != 0)
          b(113, paramaw, "badform_summary", null, dm.a);
        if (paramaw.c != 0)
        {
          if ((0x4 & paramaw.c) != 0)
            b(4, paramaw, "badaccess_missing_summary", null, dm.a);
          if ((0x1 & paramaw.c) != 0)
            b(1, paramaw, "badaccess_missing_image_alt", null, dm.a);
          if ((0x8 & paramaw.c) != 0)
            b(8, paramaw, "badaccess_missing_image_map", null, dm.a);
          if ((0x2 & paramaw.c) != 0)
            b(2, paramaw, "badaccess_missing_link_alt", null, dm.a);
          if (((0x10 & paramaw.c) != 0) && ((0x20 & paramaw.c) == 0))
            b(16, paramaw, "badaccess_frames", null, dm.a);
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = "http://www.w3.org/WAI/GL";
          b(112, paramaw, "badaccess_summary", arrayOfObject1, dm.a);
        }
        if (paramaw.d != 0)
        {
          if ((0x2 & paramaw.d) != 0)
            b(2, paramaw, "badlayout_using_layer", null, dm.a);
          if ((0x1 & paramaw.d) != 0)
            b(1, paramaw, "badlayout_using_spacer", null, dm.a);
          if ((0x8 & paramaw.d) != 0)
            b(8, paramaw, "badlayout_using_font", null, dm.a);
          if ((0x4 & paramaw.d) != 0)
            b(4, paramaw, "badlayout_using_nobr", null, dm.a);
          if ((0x10 & paramaw.d) != 0)
            b(16, paramaw, "badlayout_using_body", null, dm.a);
        }
        return;
        label533: if (!"MacRoman".equals(paramaw.F.b()))
          break label579;
        j = 2;
        break;
        label554: if ("MacRoman".equals(paramaw.F.b()))
        {
          i = 2;
          continue;
        }
        i = 0;
      }
      label579: j = 0;
    }
  }

  public void a(aw paramaw, int paramInt1, int paramInt2)
  {
    paramaw.g = (1 + paramaw.g);
    if (paramaw.h > paramaw.F.ah);
    while (true)
    {
      return;
      if (paramaw.F.j)
      {
        String str = Integer.toHexString(paramInt2);
        if ((paramInt1 & 0xFFFFFFFE) == 80)
        {
          paramaw.e = (0x50 | paramaw.e);
          Object[] arrayOfObject6 = new Object[2];
          arrayOfObject6[0] = paramaw.F.b();
          arrayOfObject6[1] = be.d.a(null, new Integer(paramInt2), paramaw.F);
          b(paramInt1, paramaw, "encoding_mismatch", arrayOfObject6, dm.c);
          continue;
        }
        if ((paramInt1 & 0xFFFFFFFE) == 76)
        {
          paramaw.e = (0x4C | paramaw.e);
          Object[] arrayOfObject5 = new Object[2];
          arrayOfObject5[0] = new Integer(paramInt1 & 0x1);
          arrayOfObject5[1] = str;
          b(paramInt1, paramaw, "invalid_char", arrayOfObject5, dm.c);
          continue;
        }
        if ((paramInt1 & 0xFFFFFFFE) == 77)
        {
          paramaw.e = (0x4D | paramaw.e);
          Object[] arrayOfObject4 = new Object[2];
          arrayOfObject4[0] = new Integer(paramInt1 & 0x1);
          arrayOfObject4[1] = str;
          b(paramInt1, paramaw, "invalid_char", arrayOfObject4, dm.c);
          continue;
        }
        if ((paramInt1 & 0xFFFFFFFE) == 78)
        {
          paramaw.e = (0x4E | paramaw.e);
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = new Integer(paramInt1 & 0x1);
          arrayOfObject3[1] = str;
          b(paramInt1, paramaw, "invalid_utf8", arrayOfObject3, dm.c);
          continue;
        }
        if ((paramInt1 & 0xFFFFFFFE) == 79)
        {
          paramaw.e = (0x4F | paramaw.e);
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = new Integer(paramInt1 & 0x1);
          arrayOfObject2[1] = str;
          b(paramInt1, paramaw, "invalid_utf16", arrayOfObject2, dm.c);
          continue;
        }
        if ((paramInt1 & 0xFFFFFFFE) != 82)
          continue;
        paramaw.e = (0x52 | paramaw.e);
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = new Integer(paramInt1 & 0x1);
        arrayOfObject1[1] = str;
        b(paramInt1, paramaw, "invalid_ncr", arrayOfObject1, dm.c);
        continue;
      }
    }
  }

  public void a(aw paramaw, ay paramay1, ay paramay2, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    if ((paramShort != 8) || (paramaw.f == 0))
      paramaw.g = (1 + paramaw.g);
    if (paramaw.h > paramaw.F.ah);
    label1474: 
    while (true)
    {
      return;
      if (paramaw.F.j)
        switch (paramShort)
        {
        case 16:
        case 18:
        case 22:
        case 42:
        case 43:
        default:
        case 6:
        case 7:
        case 8:
        case 9:
        case 24:
        case 10:
        case 11:
        case 34:
        case 12:
        case 13:
        case 38:
        case 14:
        case 15:
        case 19:
        case 21:
        case 20:
        case 39:
        case 23:
        case 17:
        case 25:
        case 26:
        case 28:
        case 35:
        case 27:
        case 29:
        case 30:
        case 31:
        case 32:
        case 33:
        case 37:
        case 36:
        case 40:
        case 41:
        case 44:
        }
      while (true)
      {
        if ((paramShort != 8) || (paramaw.f == 0))
          break label1474;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = a(paramay2);
        b(paramShort, paramaw, "discarding_unexpected", arrayOfObject1, dm.d);
        break;
        Object[] arrayOfObject25 = new Object[1];
        arrayOfObject25[0] = paramay1.n;
        b(paramShort, paramaw, "missing_endtag_for", arrayOfObject25, dm.c);
        continue;
        Object[] arrayOfObject24 = new Object[2];
        arrayOfObject24[0] = paramay1.n;
        arrayOfObject24[1] = a(paramay2);
        b(paramShort, paramaw, "missing_endtag_before", arrayOfObject24, dm.c);
        continue;
        if (paramaw.f != 0)
          continue;
        Object[] arrayOfObject23 = new Object[1];
        arrayOfObject23[0] = a(paramay2);
        b(paramShort, paramaw, "discarding_unexpected", arrayOfObject23, dm.c);
        continue;
        Object[] arrayOfObject22 = new Object[1];
        arrayOfObject22[0] = a(paramay2);
        b(paramShort, paramaw, "nested_emphasis", arrayOfObject22, dm.b);
        continue;
        Object[] arrayOfObject21 = new Object[1];
        arrayOfObject21[0] = paramay1.n;
        b(paramShort, paramaw, "coerce_to_endtag", arrayOfObject21, dm.b);
        continue;
        Object[] arrayOfObject20 = new Object[2];
        arrayOfObject20[0] = a(paramay2);
        arrayOfObject20[1] = paramay1.n;
        b(paramShort, paramaw, "non_matching_endtag", arrayOfObject20, dm.c);
        continue;
        Object[] arrayOfObject19 = new Object[2];
        arrayOfObject19[0] = a(paramay2);
        arrayOfObject19[1] = paramay1.n;
        b(paramShort, paramaw, "tag_not_allowed_in", arrayOfObject19, dm.c);
        continue;
        b(paramShort, paramaw, "doctype_after_tags", null, dm.c);
        continue;
        Object[] arrayOfObject18 = new Object[1];
        arrayOfObject18[0] = paramay2.n;
        b(paramShort, paramaw, "missing_starttag", arrayOfObject18, dm.c);
        continue;
        if (paramay1 != null)
        {
          Object[] arrayOfObject17 = new Object[2];
          arrayOfObject17[0] = paramay2.n;
          arrayOfObject17[1] = paramay1.n;
          b(paramShort, paramaw, "unexpected_endtag_in", arrayOfObject17, dm.c);
          continue;
        }
        Object[] arrayOfObject16 = new Object[1];
        arrayOfObject16[0] = paramay2.n;
        b(paramShort, paramaw, "unexpected_endtag", arrayOfObject16, dm.c);
        continue;
        if (paramay1 != null)
        {
          Object[] arrayOfObject15 = new Object[2];
          arrayOfObject15[0] = paramay2.n;
          arrayOfObject15[1] = paramay1.n;
          b(paramShort, paramaw, "too_many_elements_in", arrayOfObject15, dm.c);
          continue;
        }
        Object[] arrayOfObject14 = new Object[1];
        arrayOfObject14[0] = paramay2.n;
        b(paramShort, paramaw, "too_many_elements", arrayOfObject14, dm.c);
        continue;
        Object[] arrayOfObject13 = new Object[1];
        arrayOfObject13[0] = a(paramay2);
        b(paramShort, paramaw, "using_br_inplace_of", arrayOfObject13, dm.c);
        continue;
        Object[] arrayOfObject12 = new Object[1];
        arrayOfObject12[0] = paramay2.n;
        b(paramShort, paramaw, "inserting_tag", arrayOfObject12, dm.c);
        continue;
        Object[] arrayOfObject11 = new Object[1];
        arrayOfObject11[0] = a(paramay2);
        b(paramShort, paramaw, "cant_be_nested", arrayOfObject11, dm.c);
        continue;
        Object[] arrayOfObject10 = new Object[1];
        arrayOfObject10[0] = a(paramay2);
        b(paramShort, paramaw, "proprietary_element", arrayOfObject10, dm.c);
        if (paramay2.m == localdj.W)
        {
          paramaw.d = (0x2 | paramaw.d);
          continue;
        }
        if (paramay2.m == localdj.V)
        {
          paramaw.d = (0x1 | paramaw.d);
          continue;
        }
        if (paramay2.m != localdj.S)
          continue;
        paramaw.d = (0x4 | paramaw.d);
        continue;
        if ((paramay1.m != null) && ((0x80000 & paramay1.m.c) != 0))
        {
          Object[] arrayOfObject9 = new Object[2];
          arrayOfObject9[0] = a(paramay1);
          arrayOfObject9[1] = a(paramay2);
          b(paramShort, paramaw, "obsolete_element", arrayOfObject9, dm.c);
          continue;
        }
        Object[] arrayOfObject8 = new Object[2];
        arrayOfObject8[0] = a(paramay1);
        arrayOfObject8[1] = a(paramay2);
        b(paramShort, paramaw, "replacing_element", arrayOfObject8, dm.c);
        continue;
        Object[] arrayOfObject7 = new Object[1];
        arrayOfObject7[0] = a(paramay1);
        b(paramShort, paramaw, "unescaped_element", arrayOfObject7, dm.c);
        continue;
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = a(paramay1);
        b(paramShort, paramaw, "trim_empty_element", arrayOfObject6, dm.c);
        continue;
        b(paramShort, paramaw, "missing_title_element", null, dm.c);
        continue;
        Object[] arrayOfObject5 = new Object[1];
        arrayOfObject5[0] = a(paramay1);
        b(paramShort, paramaw, "illegal_nesting", arrayOfObject5, dm.c);
        continue;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = a(paramay2);
        b(paramShort, paramaw, "noframes_content", arrayOfObject4, dm.c);
        continue;
        b(paramShort, paramaw, "inconsistent_version", null, dm.c);
        continue;
        b(paramShort, paramaw, "malformed_doctype", null, dm.c);
        continue;
        b(paramShort, paramaw, "content_after_body", null, dm.c);
        continue;
        b(paramShort, paramaw, "malformed_comment", null, dm.c);
        continue;
        b(paramShort, paramaw, "bad_comment_chars", null, dm.c);
        continue;
        b(paramShort, paramaw, "bad_xml_comment", null, dm.c);
        continue;
        b(paramShort, paramaw, "bad_cdata_content", null, dm.c);
        continue;
        b(paramShort, paramaw, "inconsistent_namespace", null, dm.c);
        continue;
        b(paramShort, paramaw, "dtype_not_upper_case", null, dm.c);
        continue;
        paramaw.i = paramaw.a.b();
        paramaw.j = paramaw.a.a();
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = a(paramay1);
        b(paramShort, paramaw, "unexpected_end_of_file", arrayOfObject3, dm.c);
        continue;
        b(paramShort, paramaw, "nested_quotation", null, dm.c);
        continue;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = a(paramay1);
        b(paramShort, paramaw, "element_not_empty", arrayOfObject2, dm.c);
        continue;
        b(paramShort, paramaw, "missing_doctype", null, dm.c);
      }
    }
  }

  public void a(aw paramaw, ay paramay, b paramb, short paramShort)
  {
    if (paramShort == 52)
    {
      paramaw.h = (1 + paramaw.h);
      if (paramaw.h <= paramaw.F.ah)
        break label45;
    }
    while (true)
    {
      return;
      paramaw.g = (1 + paramaw.g);
      break;
      label45: if (paramShort == 52)
      {
        Object[] arrayOfObject24 = new Object[1];
        arrayOfObject24[0] = a(paramay);
        b(paramShort, paramaw, "unexpected_gt", arrayOfObject24, dm.d);
      }
      if (!paramaw.F.j)
        continue;
      switch (paramShort)
      {
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 52:
      default:
        break;
      case 36:
        paramaw.i = paramaw.a.b();
        paramaw.j = paramaw.a.a();
        Object[] arrayOfObject23 = new Object[1];
        arrayOfObject23[0] = a(paramay);
        b(paramShort, paramaw, "unexpected_end_of_file", arrayOfObject23, dm.c);
        break;
      case 48:
        Object[] arrayOfObject22 = new Object[1];
        arrayOfObject22[0] = paramb.f;
        b(paramShort, paramaw, "unknown_attribute", arrayOfObject22, dm.c);
        break;
      case 49:
        Object[] arrayOfObject21 = new Object[2];
        arrayOfObject21[0] = a(paramay);
        arrayOfObject21[1] = paramb.f;
        b(paramShort, paramaw, "missing_attribute", arrayOfObject21, dm.c);
        break;
      case 50:
        Object[] arrayOfObject20 = new Object[2];
        arrayOfObject20[0] = a(paramay);
        arrayOfObject20[1] = paramb.f;
        b(paramShort, paramaw, "missing_attr_value", arrayOfObject20, dm.c);
        break;
      case 56:
        Object[] arrayOfObject19 = new Object[1];
        arrayOfObject19[0] = a(paramay);
        b(paramShort, paramaw, "missing_imagemap", arrayOfObject19, dm.c);
        paramaw.c = (0x8 | paramaw.c);
        break;
      case 51:
        Object[] arrayOfObject18 = new Object[3];
        arrayOfObject18[0] = a(paramay);
        arrayOfObject18[1] = paramb.f;
        arrayOfObject18[2] = paramb.g;
        b(paramShort, paramaw, "bad_attribute_value", arrayOfObject18, dm.c);
        break;
      case 71:
        Object[] arrayOfObject17 = new Object[2];
        arrayOfObject17[0] = a(paramay);
        arrayOfObject17[1] = paramb.f;
        b(paramShort, paramaw, "xml_id_sintax", arrayOfObject17, dm.c);
        break;
      case 57:
        Object[] arrayOfObject16 = new Object[2];
        arrayOfObject16[0] = a(paramay);
        arrayOfObject16[1] = paramb.f;
        b(paramShort, paramaw, "xml_attribute_value", arrayOfObject16, dm.c);
        break;
      case 59:
        Object[] arrayOfObject15 = new Object[1];
        arrayOfObject15[0] = a(paramay);
        b(paramShort, paramaw, "unexpected_quotemark", arrayOfObject15, dm.c);
        break;
      case 58:
        Object[] arrayOfObject14 = new Object[1];
        arrayOfObject14[0] = a(paramay);
        b(paramShort, paramaw, "missing_quotemark", arrayOfObject14, dm.c);
        break;
      case 55:
        Object[] arrayOfObject13 = new Object[3];
        arrayOfObject13[0] = a(paramay);
        arrayOfObject13[1] = paramb.g;
        arrayOfObject13[2] = paramb.f;
        b(paramShort, paramaw, "repeated_attribute", arrayOfObject13, dm.c);
        break;
      case 54:
        Object[] arrayOfObject12 = new Object[2];
        arrayOfObject12[0] = a(paramay);
        arrayOfObject12[1] = paramb.g;
        b(paramShort, paramaw, "proprietary_attr_value", arrayOfObject12, dm.c);
        break;
      case 53:
        Object[] arrayOfObject11 = new Object[2];
        arrayOfObject11[0] = a(paramay);
        arrayOfObject11[1] = paramb.f;
        b(paramShort, paramaw, "proprietary_attribute", arrayOfObject11, dm.c);
        break;
      case 60:
        Object[] arrayOfObject10 = new Object[1];
        arrayOfObject10[0] = a(paramay);
        b(paramShort, paramaw, "id_name_mismatch", arrayOfObject10, dm.c);
        break;
      case 61:
        Object[] arrayOfObject9 = new Object[1];
        arrayOfObject9[0] = a(paramay);
        b(paramShort, paramaw, "backslash_in_uri", arrayOfObject9, dm.c);
        break;
      case 62:
        Object[] arrayOfObject8 = new Object[1];
        arrayOfObject8[0] = a(paramay);
        b(paramShort, paramaw, "fixed_backslash", arrayOfObject8, dm.c);
        break;
      case 63:
        Object[] arrayOfObject7 = new Object[1];
        arrayOfObject7[0] = a(paramay);
        b(paramShort, paramaw, "illegal_uri_reference", arrayOfObject7, dm.c);
        break;
      case 64:
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = a(paramay);
        b(paramShort, paramaw, "escaped_illegal_uri", arrayOfObject6, dm.c);
        break;
      case 65:
        Object[] arrayOfObject5 = new Object[1];
        arrayOfObject5[0] = a(paramay);
        b(paramShort, paramaw, "newline_in_uri", arrayOfObject5, dm.c);
        break;
      case 66:
        Object[] arrayOfObject4 = new Object[2];
        arrayOfObject4[0] = a(paramay);
        arrayOfObject4[1] = paramb.g;
        b(paramShort, paramaw, "anchor_not_unique", arrayOfObject4, dm.c);
        break;
      case 67:
        b(paramShort, paramaw, "entity_in_id", null, dm.c);
        break;
      case 68:
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = a(paramay);
        arrayOfObject3[1] = paramb.f;
        b(paramShort, paramaw, "joining_attribute", arrayOfObject3, dm.c);
        break;
      case 69:
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = a(paramay);
        b(paramShort, paramaw, "expected_equalsign", arrayOfObject2, dm.c);
        break;
      case 70:
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = a(paramay);
        arrayOfObject1[1] = paramb.g;
        arrayOfObject1[2] = paramb.f;
        b(paramShort, paramaw, "attr_value_not_lcase", arrayOfObject1, dm.c);
      }
    }
  }

  public void a(aw paramaw, short paramShort, String paramString, int paramInt)
  {
    paramaw.g = (1 + paramaw.g);
    if (paramaw.h > paramaw.F.ah);
    while (true)
    {
      return;
      if (paramaw.F.j)
        switch (paramShort)
        {
        default:
          break;
        case 1:
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = paramString;
          b(paramShort, paramaw, "missing_semicolon", arrayOfObject3, dm.c);
          break;
        case 2:
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramString;
          b(paramShort, paramaw, "missing_semicolon_ncr", arrayOfObject2, dm.c);
          break;
        case 3:
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = paramString;
          b(paramShort, paramaw, "unknown_entity", arrayOfObject1, dm.c);
          break;
        case 4:
          b(paramShort, paramaw, "unescaped_ampersand", null, dm.c);
          break;
        case 5:
          b(paramShort, paramaw, "apos_undefined", null, dm.c);
          continue;
        }
    }
  }

  public void a(PrintWriter paramPrintWriter)
  {
    a(paramPrintWriter, "needs_author_intervention", null, dm.a);
  }

  public void a(PrintWriter paramPrintWriter, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new Integer(paramInt);
    a(paramPrintWriter, "slides_found", arrayOfObject, dm.a);
  }

  public void a(PrintWriter paramPrintWriter, aw paramaw)
  {
    if ((paramaw.g > 0) || (paramaw.h > 0))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = new Integer(paramaw.g);
      arrayOfObject[1] = new Integer(paramaw.h);
      a(paramPrintWriter, "num_warnings", arrayOfObject, dm.a);
    }
    while (true)
    {
      return;
      a(paramPrintWriter, "no_warnings", null, dm.a);
    }
  }

  public void a(PrintWriter paramPrintWriter, aw paramaw, String paramString, ay paramay)
  {
    String str1 = paramaw.f();
    int[] arrayOfInt = new int[1];
    paramaw.i = 1;
    paramaw.j = 1;
    StringBuffer localStringBuffer;
    int i;
    int j;
    String str2;
    if (paramay != null)
    {
      localStringBuffer = new StringBuffer();
      i = paramay.e;
      j = 0;
      if (i >= paramay.f)
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = paramString;
        arrayOfObject1[1] = localStringBuffer;
        b(110, paramaw, "doctype_given", arrayOfObject1, dm.a);
      }
    }
    else
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      if (str1 == null)
        break label204;
      str2 = str1;
      label107: arrayOfObject2[1] = str2;
      b(111, paramaw, "report_version", arrayOfObject2, dm.a);
      return;
    }
    int k = paramay.g[i];
    int m;
    if (k < 0)
      m = i + bc.a(paramay.g, i, arrayOfInt);
    for (int n = arrayOfInt[0]; ; n = k)
    {
      if (n == 34)
        j++;
      while (true)
      {
        i = m + 1;
        break;
        if (j != 1)
          continue;
        localStringBuffer.append((char)n);
      }
      label204: str2 = "HTML proprietary";
      break label107;
      m = i;
    }
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public void b(aw paramaw, ay paramay1, ay paramay2, short paramShort)
  {
    paramaw.h = (1 + paramaw.h);
    if (paramaw.h > paramaw.F.ah);
    while (true)
    {
      return;
      if (paramShort == 16)
      {
        b(paramShort, paramaw, "suspected_missing_quote", null, dm.d);
        continue;
      }
      if (paramShort == 18)
      {
        b(paramShort, paramaw, "duplicate_frameset", null, dm.d);
        continue;
      }
      if (paramShort == 22)
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = a(paramay2);
        b(paramShort, paramaw, "unknown_element", arrayOfObject3, dm.d);
        continue;
      }
      if (paramShort != 13)
        continue;
      if (paramay1 != null)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = paramay2.n;
        arrayOfObject2[1] = paramay1.n;
        b(paramShort, paramaw, "unexpected_endtag_in", arrayOfObject2, dm.d);
        continue;
      }
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramay2.n;
      b(paramShort, paramaw, "unexpected_endtag", arrayOfObject1, dm.d);
    }
  }

  public void b(PrintWriter paramPrintWriter)
  {
    a(paramPrintWriter, "missing_body", null, dm.d);
  }

  public void c(PrintWriter paramPrintWriter)
  {
    a(paramPrintWriter, "bad_tree", null, dm.d);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cn
 * JD-Core Version:    0.6.0
 */