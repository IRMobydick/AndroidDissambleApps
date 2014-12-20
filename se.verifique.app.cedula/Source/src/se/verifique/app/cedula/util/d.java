package se.verifique.app.cedula.util;

import a.a.a.dk;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.http.Header;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.a.i;
import se.verifique.app.cedula.a.j;
import se.verifique.app.cedula.b.a;

public class d
  implements b
{
  private se.verifique.app.cedula.a.e a(XPath paramXPath, Document paramDocument, int paramInt)
  {
    se.verifique.app.cedula.a.e locale1 = new se.verifique.app.cedula.a.e();
    try
    {
      NodeList localNodeList1 = (NodeList)paramXPath.evaluate("/html/body/form/table[3]/tr/td/table/tr[2]/td/table/tr[" + paramInt + "]/td[5]", paramDocument, XPathConstants.NODESET);
      if ((localNodeList1 != null) && (localNodeList1.getLength() > 0))
        locale1.a(localNodeList1.item(0).getChildNodes().item(0).getNodeValue());
    }
    catch (XPathExpressionException localXPathExpressionException2)
    {
      try
      {
        NodeList localNodeList2 = (NodeList)paramXPath.evaluate("/html/body/form/table[3]/tr/td/table/tr[2]/td/table/tr[" + paramInt + "]/td[6]", paramDocument, XPathConstants.NODESET);
        if ((localNodeList2 != null) && (localNodeList2.getLength() > 0))
          locale1.c(localNodeList2.item(0).getChildNodes().item(0).getNodeValue());
      }
      catch (XPathExpressionException localXPathExpressionException2)
      {
        try
        {
          NodeList localNodeList3 = (NodeList)paramXPath.evaluate("/html/body/form/table[3]/tr/td/table/tr[2]/td/table/tr[" + paramInt + "]/td[13]/div", paramDocument, XPathConstants.NODESET);
          if ((localNodeList3 != null) && (localNodeList3.getLength() > 0))
          {
            locale1.b(localNodeList3.item(0).getChildNodes().item(0).getNodeValue());
            locale2 = locale1;
          }
          while (true)
          {
            return locale2;
            locale2 = null;
            continue;
            localXPathExpressionException1 = localXPathExpressionException1;
            localXPathExpressionException1.printStackTrace();
            locale2 = null;
            continue;
            locale2 = null;
            continue;
            localXPathExpressionException2 = localXPathExpressionException2;
            localXPathExpressionException2.printStackTrace();
            locale2 = null;
            continue;
            locale2 = null;
          }
        }
        catch (XPathExpressionException localXPathExpressionException3)
        {
          while (true)
          {
            localXPathExpressionException3.printStackTrace();
            se.verifique.app.cedula.a.e locale2 = null;
          }
        }
      }
    }
  }

  private void e(String paramString)
  {
    if (("VFQ-TO".equals(paramString)) || ("ERROR".equals(paramString)))
      throw new a(paramString);
  }

  public String a()
  {
    String str = se.verifique.app.a.c.a("http://xyz.verifique.se/h/v/f/q/a024.json", 1, null, null, null, null, null, false, null, false);
    if (("VFQ-TO".equals(str)) || ("ERROR".equals(str)))
    {
      str = "{ \"opciones\" : [ { \"codigo\": \"-10000\",     \"tipo\": \"2\",     \"descripcion\": \"No se pudo conectar con el sistema de Verifíquese. hacer clic aquí para verificar servicio.\",   \"error\": \"\",    \"url\": \"http://verifique.se\",    \"urlBinario\": \"\"   } ] }";
      System.out.println("JSON=" + str);
    }
    return str;
  }

  public h a(String paramString)
  {
    f localf = new f();
    localf.b("http://www.fosyga.gov.co/Aplicaciones/AfiliadoWebBDUA/Afiliado/Formulario/buda_consulta_afil_sin_dnn.aspx?id=" + paramString + "&tipodocumento=CC");
    String str = se.verifique.app.a.c.a(localf);
    e(str);
    h localh = new h();
    localh.c(paramString);
    localh.a(se.verifique.app.a.c.a(str, "<span id=\"lblNombreDato2\">(.*?)</span>"));
    localh.b(se.verifique.app.a.c.a(str, "<span id=\"dldApellidosData2\">(.*?)</span>"));
    return localh;
  }

  public h a(h paramh)
  {
    f localf = new f();
    localf.b("http://www3.registraduria.gov.co/censo/_censoresultado.php?nCedula=" + paramh.f());
    String str = se.verifique.app.a.c.a(localf);
    e(str);
    i locali = new i();
    locali.a(se.verifique.app.a.c.a(str, "<td width=\"400\" class=\"tblbgcolort\">(.*?)</td>"));
    locali.c(se.verifique.app.a.c.a(str, "<td class=\"tblbgcolor\">(.*?)</td>", 2));
    locali.b(se.verifique.app.a.c.a(str, "<td>(.*?)</td>", 2));
    locali.d(se.verifique.app.a.c.a(str, "<div style='float:left;margin-top:6px'>(.*?)</div>"));
    locali.f(se.verifique.app.a.c.a(str, "<td>(.*?)</td>", 4));
    locali.e(se.verifique.app.a.c.a(str, "<td class=\"tblbgcolor\">(.*?)</td>", 5));
    paramh.a(locali);
    return paramh;
  }

  public String b()
  {
    String str = se.verifique.app.a.c.a("http://xyz.verifique.se/h/v/f/q/a024_v.json", 1, null, null, null, null, null, false, null, false);
    if (("VFQ-TO".equals(str)) || ("ERROR".equals(str)))
      str = "1";
    return str;
  }

  public String b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("HANDLE_REDIRECTS_VERIFIQUESE", "NO");
    localHashMap.put("Referer", "https://sedeelectronica.archivogeneral.gov.co/SedeElectronica/verifyDocs.jsp");
    localHashMap.put("Accept-Language", "es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3");
    localHashMap.put("Cache-Control", "no-cache");
    localHashMap.put("Accept-Encoding", "deflate");
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0");
    localHashMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    localHashMap.put("Content-Type", "text/x-gwt-rpc; charset=UTF-8");
    localHashMap.put("X-GWT-Module-Base", "https://sedeelectronica.archivogeneral.gov.co/SedeElectronica/com.indenova.validadorDocumental/");
    localHashMap.put("X-GWT-Permutation", "C67A168CFC034CD1DC13BECF869A3935");
    String str1 = se.verifique.app.a.c.a("https://sedeelectronica.archivogeneral.gov.co/SedeElectronica/utilservice", 2, null, null, null, null, localHashMap, true, "7|0|7|https://sedeelectronica.archivogeneral.gov.co/SedeElectronica/com.indenova.validadorDocumental/|433ECF384D5AEF15409780C409117A63|com.indenova.client.UtilService|verifyDocByHash|java.lang.Integer/3438268394|java.lang.String/2004016611|" + paramString + "|1|2|3|4|2|5|6|0|7|", false);
    if (("VFQ-TO".equals(str1)) || ("ERROR".equals(str1)))
      throw new a(str1);
    String str2 = str1.substring(5);
    StringTokenizer localStringTokenizer = new StringTokenizer(str2.substring(0, -1 + str2.length()), ",");
    int i = 0;
    String str6;
    for (String str3 = ""; ; str3 = localStringTokenizer.nextToken())
    {
      if (i >= 32)
      {
        String str4 = str3.substring(1);
        String str5 = str4.substring(0, -1 + str4.length());
        System.out.println("GUID=" + str5);
        str6 = se.verifique.app.a.c.a("https://sedeelectronica.archivogeneral.gov.co/SedeElectronica/viewerGWT/download.jsp?type=original&iduser=-1&name=prueba.pdf&guid=" + str5, 1, null, null, null, null, localHashMap, false, null, true);
        if ((!"VFQ-TO".equals(str6)) && (!"ERROR".equals(str6)))
          break;
        throw new a(str1);
      }
      i++;
    }
    return str6;
  }

  public h b(h paramh)
  {
    int i = 2;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("pagina", ".%2Fverificar%2Fcontenido_liquidacion_pago_linea.jsp"));
    localArrayList.add(new BasicNameValuePair("accion", "3"));
    localArrayList.add(new BasicNameValuePair("documentoIdentidad", "Cedula"));
    localArrayList.add(new BasicNameValuePair("TipoConsulta", "P"));
    localArrayList.add(new BasicNameValuePair("IsComp", "false"));
    localArrayList.add(new BasicNameValuePair("IsResol", "false"));
    localArrayList.add(new BasicNameValuePair("tipoDocumento", "1"));
    localArrayList.add(new BasicNameValuePair("identificacion", paramh.f()));
    localArrayList.add(new BasicNameValuePair("radiobutton", "S"));
    localArrayList.add(new BasicNameValuePair("numero", ""));
    localArrayList.add(new BasicNameValuePair("txtCaptcha", "a+j++D+P+9+N+J"));
    localArrayList.add(new BasicNameValuePair("txtInput", "ajDP9NJ"));
    String str = se.verifique.app.a.c.a("https://consulta.simit.org.co/Simit/verificar/contenido_liquidacion_pago_linea.jsp?estadoAutorizacion=S", i, localArrayList, null, null, null, null, false, null, false);
    if (("VFQ-TO".equals(str)) || ("ERROR".equals(str)))
      throw new a(str);
    dk localdk = new dk();
    localdk.c(false);
    localdk.a(false);
    localdk.b(true);
    Document localDocument = localdk.b(new ByteArrayInputStream(str.getBytes()), null);
    XPath localXPath = XPathFactory.newInstance().newXPath();
    for (se.verifique.app.cedula.a.e locale = a(localXPath, localDocument, i); ; locale = a(localXPath, localDocument, i))
    {
      if (locale == null)
        return paramh;
      paramh.a(locale);
      i++;
    }
  }

  public String c()
  {
    Object localObject = null;
    String str = se.verifique.app.a.c.a("http://xyz.verifique.se/h/v/f/q/x.json", 1, null, null, null, null, null, false, null, false);
    if (("VFQ-TO".equals(str)) || ("ERROR".equals(str)))
      System.out.println("JSON_CEDULAS=" + null);
    while (true)
    {
      return localObject;
      localObject = str;
    }
  }

  public String c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("HANDLE_REDIRECTS_VERIFIQUESE", "NO");
    localHashMap.put("Referer", "https://sedeelectronica.archivogeneral.gov.co/SedeElectronica/verifyDocs.jsp");
    localHashMap.put("Accept-Language", "es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3");
    localHashMap.put("Cache-Control", "no-cache");
    localHashMap.put("Accept-Encoding", "deflate");
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0");
    localHashMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    localHashMap.put("Content-Type", "text/x-gwt-rpc; charset=UTF-8");
    f localf = new f();
    localf.b("http://cfiscal.contraloria.gov.co/siborinternet/certificados/imprimirPersonaNatural.asp?ced=" + paramString + "&tp=C.C.");
    localf.b(localHashMap);
    localf.b(true);
    String str = se.verifique.app.a.c.a(localf);
    e(str);
    return str;
  }

  public h c(h paramh)
  {
    String str = se.verifique.app.a.c.a("http://www.fosyga.gov.co/Aplicaciones/AfiliadoWebBDUA/Afiliado/Formulario/buda_consulta_afil_sin_dnn.aspx?id=" + paramh.f() + "&tipodocumento=CC", 1, null, null, null, null, null, false, null, false);
    if (("VFQ-TO".equals(str)) || ("ERROR".equals(str)))
      throw new a(str);
    se.verifique.app.cedula.a.b localb = new se.verifique.app.cedula.a.b();
    localb.a(se.verifique.app.a.c.a(str, "<span id=\"lblNombreDato2\">(.*?)</span>"));
    localb.b(se.verifique.app.a.c.a(str, "<span id=\"dldApellidosData2\">(.*?)</span>"));
    localb.c(se.verifique.app.a.c.a(str, "<span id=\"ldlEstadodata2\">(.*?)</span>"));
    localb.d(se.verifique.app.a.c.a(str, "<span id=\"lblEntidadData2\">(.*?)</span>"));
    localb.e(se.verifique.app.a.c.a(str, "<span id=\"ldlRegimenData2\" style=\"text-align: center\">(.*?)</span>"));
    localb.f(se.verifique.app.a.c.a(str, "<span id=\"ldlFechaAfiEntData2\">(.*?)</span>"));
    localb.g(se.verifique.app.a.c.a(str, "<span id=\"ldlDepartamentodata2\">(.*?)</span>"));
    localb.h(se.verifique.app.a.c.a(str, "<span id=\"ldlMunicipioData2\">(.*?)</span>"));
    localb.i(se.verifique.app.a.c.a(str, "<span id=\"ldlTifoAfilData2\">(.*?)</span>"));
    paramh.a(localb);
    return paramh;
  }

  public String d(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("HANDLE_REDIRECTS_VERIFIQUESE", "NO");
    localHashMap.put("Referer", "https://www.enlace-apb.com/interssi/consultarCertificacionPago.jsp");
    localHashMap.put("Accept-Language", "es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3");
    localHashMap.put("Accept-Encoding", "deflate");
    localHashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0");
    localHashMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    localHashMap.put("Content-Type", "application/x-www-form-urlencoded; charset=ISO-8859-1");
    Calendar localCalendar = GregorianCalendar.getInstance();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("tipoID", "CC"));
    localArrayList.add(new BasicNameValuePair("numeroID", paramString));
    localArrayList.add(new BasicNameValuePair("ano", localCalendar.get(1)));
    if ((1 + localCalendar.get(2)).length() == 1);
    for (String str1 = "0" + (1 + localCalendar.get(2)); ; str1 = 1 + localCalendar.get(2))
    {
      localArrayList.add(new BasicNameValuePair("mes", str1));
      localArrayList.add(new BasicNameValuePair("clicks", "1"));
      localArrayList.add(new BasicNameValuePair("tarea", "verCertificadoTresNuevo"));
      localArrayList.add(new BasicNameValuePair("empleado", "CC--" + paramString));
      f localf = new f();
      localf.b("https://www.enlace-apb.com/interssi/ServletEmpleado");
      localf.b(localHashMap);
      localf.a(localArrayList);
      localf.a(2);
      localf.b(true);
      String str2 = se.verifique.app.a.c.a(localf);
      e(str2);
      return str2;
    }
  }

  public h d(h paramh)
  {
    int i = 0;
    h localh = null;
    String str1 = se.verifique.app.a.c.a("https://copnia.gov.co/matriculas/?q=" + paramh.f(), 1, null, null, null, null, null, false, null, false);
    if (("VFQ-TO".equals(str1)) || ("ERROR".equals(str1)))
      throw new a(str1);
    dk localdk = new dk();
    localdk.c(false);
    localdk.a(false);
    localdk.b(true);
    Document localDocument = localdk.b(new ByteArrayInputStream(str1.getBytes()), null);
    XPath localXPath = XPathFactory.newInstance().newXPath();
    Object localObject = "";
    try
    {
      NodeList localNodeList = (NodeList)localXPath.evaluate("/html/body/div.container-bg/div.container/div.container-base/div/p/strong", localDocument, XPathConstants.NODESET);
      if ((localNodeList != null) && (localNodeList.getLength() > 0));
      while (true)
      {
        int j = localNodeList.getLength();
        if (i >= j)
        {
          paramh.d((String)localObject);
          localh = paramh;
          return localh;
        }
        String str2 = localObject + localNodeList.item(0).getChildNodes().item(i).getNodeValue() + " ";
        localObject = str2;
        i++;
      }
    }
    catch (XPathExpressionException localXPathExpressionException)
    {
      while (true)
        localXPathExpressionException.printStackTrace();
    }
  }

  public h e(h paramh)
  {
    e locale = new e(this);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("Content-Type", "application/x-www-form-urlencoded");
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(new BasicNameValuePair("j_username", "udi"));
    localArrayList1.add(new BasicNameValuePair("j_password", "Ud1$2030"));
    localArrayList1.add(new BasicNameValuePair("submit", "Login"));
    String str1 = se.verifique.app.a.c.a("http://23.253.33.125:8080/VerifiqueseCedula/f/c/cedula/j_security_check", 2, localArrayList1, null, locale, null, localHashMap1, false, null, false);
    if (("VFQ-TO".equals(str1)) || ("ERROR".equals(str1)))
    {
      System.out.println("Lanzando exception por error");
      throw new a(str1);
    }
    String str2 = "";
    HashMap localHashMap2;
    String str3;
    for (int i = 0; ; i++)
    {
      if (i >= locale.a.length)
      {
        localHashMap2 = new HashMap();
        localHashMap2.put("VerifiqueseDominio", "23.253.33.125");
        localHashMap2.put("VerifiquesePath", "/VerifiqueseCedula");
        localHashMap2.put("JSESSIONID", str2);
        str3 = se.verifique.app.a.c.a("http://23.253.33.125:8080/VerifiqueseCedula/f/c/cedula/List.xhtml", 1, null, localHashMap2, locale, null, null, false, null, false);
        if ((!"VFQ-TO".equals(str3)) && (!"ERROR".equals(str3)))
          break;
        System.out.println("Lanzando exception por error");
        throw new a(str3);
      }
      if (!"Set-Cookie".equals(locale.a[i].getName()))
        continue;
      String str12 = locale.a[i].getValue().substring(0, locale.a[i].getValue().indexOf(";"));
      str2 = str12.substring(1 + str12.indexOf("="), str12.length());
    }
    String str4 = se.verifique.app.a.c.a(str3, "id=\"j_id1:javax.faces.ViewState:0\" value=\"(.*?)\" autocomplete=\"off\"");
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new BasicNameValuePair("javax.faces.partial.ajax", "true"));
    localArrayList2.add(new BasicNameValuePair("javax.faces.source", "CedulaListForm:datalist:createButton"));
    localArrayList2.add(new BasicNameValuePair("javax.faces.partial.execute", "@all"));
    localArrayList2.add(new BasicNameValuePair("javax.faces.partial.render", "CedulaCreateForm"));
    localArrayList2.add(new BasicNameValuePair("CedulaListForm:datalist:createButton", "CedulaListForm:datalist:createButton"));
    localArrayList2.add(new BasicNameValuePair("CedulaListForm", "CedulaListForm"));
    localArrayList2.add(new BasicNameValuePair("CedulaListForm:datalist_selection", ""));
    localArrayList2.add(new BasicNameValuePair("javax.faces.ViewState", str4));
    String str5 = se.verifique.app.a.c.a("http://23.253.33.125:8080/VerifiqueseCedula/f/c/cedula/List.xhtml", 2, localArrayList2, localHashMap2, locale, null, null, false, null, false);
    if (("VFQ-TO".equals(str5)) || ("ERROR".equals(str5)))
    {
      System.out.println("Lanzando exception por error");
      throw new a(str5);
    }
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.add(new BasicNameValuePair("javax.faces.partial.ajax", "true"));
    localArrayList3.add(new BasicNameValuePair("javax.faces.source", "CedulaCreateForm:Save"));
    localArrayList3.add(new BasicNameValuePair("javax.faces.partial.execute", "@all"));
    localArrayList3.add(new BasicNameValuePair("javax.faces.partial.render", "CedulaCreateForm:display CedulaListForm:datalist growl"));
    localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:Save", "CedulaCreateForm:Save"));
    localArrayList3.add(new BasicNameValuePair("CedulaCreateForm", "CedulaCreateForm"));
    localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:idcedula", "4"));
    localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:numero", paramh.f()));
    String str6;
    String str7;
    label842: String str8;
    label878: String str9;
    if (paramh.c() != null)
    {
      str6 = paramh.c().c();
      localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:primernombre", str6));
      if (paramh.c() == null)
        break label1078;
      str7 = paramh.c().d();
      localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:segundonombre", str7));
      if (paramh.c() == null)
        break label1086;
      str8 = paramh.c().e();
      localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:primerapellido", str8));
      if (paramh.c() == null)
        break label1095;
      str9 = paramh.c().f();
      label914: localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:segundoapellido", str9));
      localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:fechanacimiento", "06/04/2014"));
      if (paramh.c() == null)
        break label1103;
    }
    label1078: label1086: label1095: label1103: for (String str10 = paramh.c().h(); ; str10 = "")
    {
      localArrayList3.add(new BasicNameValuePair("CedulaCreateForm:tiposangre", str10));
      localArrayList3.add(new BasicNameValuePair("javax.faces.ViewState", str4));
      String str11 = se.verifique.app.a.c.a("http://23.253.33.125:8080/VerifiqueseCedula/f/c/cedula/List.xhtml", 2, localArrayList3, localHashMap2, locale, null, null, false, null, false);
      if ((!"VFQ-TO".equals(str11)) && (!"ERROR".equals(str11)))
        break label1111;
      System.out.println("Lanzando exception por error");
      throw new a(str11);
      str6 = paramh.d();
      break;
      str7 = "";
      break label842;
      str8 = paramh.e();
      break label878;
      str9 = "";
      break label914;
    }
    label1111: return paramh;
  }

  public h f(h paramh)
  {
    e locale = new e(this);
    String str1 = se.verifique.app.a.c.a("http://www.runt.com.co/runt/ciudadanos/consultas/consulta_ciudadano_por_documento_final_public.jsf", 1, null, null, locale, null, null, false, null, false);
    if (("VFQ-TO".equals(str1)) || ("ERROR".equals(str1)))
    {
      System.out.println("Lanzando exception por error");
      throw new a(str1);
    }
    System.out.println("LIcencia HTML 1: " + str1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("VerifiqueseDominio", "www.runt.com.co");
    localHashMap.put("VerifiquesePath", "/runt");
    String str2;
    for (int i = 0; ; i++)
    {
      if (i >= locale.a.length)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("ConsultaCiudadanoPorDocumentoForm:personaTipoidentIdtipdocSearch", "C"));
        localArrayList.add(new BasicNameValuePair("ConsultaCiudadanoPorDocumentoForm:personaNrodocumeSearch", paramh.f()));
        localArrayList.add(new BasicNameValuePair("ConsultaCiudadanoPorDocumentoForm:btnconsultarCiudadano", "Buscar"));
        localArrayList.add(new BasicNameValuePair("ConsultaCiudadanoPorDocumentoForm", "ConsultaCiudadanoPorDocumentoForm"));
        localArrayList.add(new BasicNameValuePair("autoScroll", ""));
        localArrayList.add(new BasicNameValuePair("javax.faces.ViewState", "j_id1"));
        str2 = se.verifique.app.a.c.a("http://www.runt.com.co/runt/ciudadanos/consultas/consulta_ciudadano_por_documento_final_public.jsf", 2, localArrayList, localHashMap, locale, null, null, false, null, false);
        if ((!"VFQ-TO".equals(str2)) && (!"ERROR".equals(str2)))
          break;
        System.out.println("Lanzando exception por error");
        throw new a(str2);
      }
      if (!"Set-Cookie".equals(locale.a[i].getName()))
        continue;
      String str7 = locale.a[i].getValue().substring(0, locale.a[i].getValue().indexOf(";"));
      localHashMap.put(str7.substring(0, str7.indexOf("=")), str7.substring(1 + str7.indexOf("="), str7.length()));
    }
    System.out.println("LIcencia HTML 2: " + str2);
    if ("Error Interno Aplicaci&oacute;n".equals(se.verifique.app.a.c.a(str2, "<span id=\"error_form:lblTitle\" class=\"title\">(.*?)</span>")))
      throw new a("El sistema RUNT presentó un error.  Intente más tarde!");
    int j = 0;
    String str3 = se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + 0 + ":tbNumLicenciaAntiguo\">(.*?)</span>");
    String str4 = se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + 0 + ":tbNumLicenciaNuevo\">(.*?)</span>");
    if (("".equals(str3)) && ("".equals(str4)))
      return paramh;
    se.verifique.app.cedula.a.f localf = new se.verifique.app.cedula.a.f();
    label599: String str5;
    String str6;
    int k;
    if (!"".equals(str3))
    {
      localf.a(str3);
      localf.b(se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + j + ":tbFechaVencimiento\">(.*?)</span>"));
      localf.c(se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + j + ":tbEstadoLicencia\">(.*?)</span>"));
      str5 = "";
      localf.d("");
      str6 = se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + j + ":j_id70:0:tbCategoria\">(.*?)</span>");
      k = 0;
    }
    while (true)
    {
      if ((str6 == null) || ("".equals(str6)))
      {
        localf.d(str5.substring(0, -2 + str5.length()));
        localf.e(se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + j + ":tbCategoriaActual\">(.*?)</span>"));
        paramh.a(localf);
        System.out.println("Estado licencia " + (j + 1) + " " + ((se.verifique.app.cedula.a.f)paramh.k().get(j)).b());
        j++;
        str3 = se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + j + ":tbNumLicenciaAntiguo\">(.*?)</span>");
        str4 = se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + j + ":tbNumLicenciaNuevo\">(.*?)</span>");
        break;
        if ("".equals(str4))
          break label599;
        localf.a(str4);
        break label599;
      }
      str5 = str5 + str6 + ", ";
      k++;
      str6 = se.verifique.app.a.c.a(str2, "<span id=\"ConsultaCiudadanoPorDocumentoForm:pagedTableLicencias:" + j + ":j_id70:" + k + ":tbCategoria\">(.*?)</span>");
    }
  }

  public h g(h paramh)
  {
    e locale = new e(this);
    String str1 = se.verifique.app.a.c.a("http://siri.procuraduria.gov.co:8086/CertWEB/Certificado.aspx?tpo=2", 1, null, null, locale, null, null, false, null, false);
    if (("VFQ-TO".equals(str1)) || ("ERROR".equals(str1)))
    {
      System.out.println("Lanzando exception por error");
      throw new a(str1);
    }
    System.out.println("PROCURADURIA HTML 1: " + str1);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("VerifiqueseDominio", "siri.procuraduria.gov.co");
    localHashMap1.put("VerifiquesePath", "/");
    int i = 0;
    String str5;
    if (i >= locale.a.length)
    {
      String str3 = se.verifique.app.a.c.a(str1, "value=\"(.*?)\" />", 1);
      System.out.println("VIEWSTATE=" + str3);
      String str4 = se.verifique.app.a.c.a(str1, "value=\"(.*?)\" />", 2);
      System.out.println("EVENTVALIDATION=" + str4);
      ArrayList localArrayList1 = new ArrayList();
      localArrayList1.add(new BasicNameValuePair("__EVENTTARGET", ""));
      localArrayList1.add(new BasicNameValuePair("__EVENTARGUMENT", ""));
      localArrayList1.add(new BasicNameValuePair("__LASTFOCUS", ""));
      localArrayList1.add(new BasicNameValuePair("__VIEWSTATE", str3));
      localArrayList1.add(new BasicNameValuePair("__EVENTVALIDATION", str4));
      localArrayList1.add(new BasicNameValuePair("ddlTipoID", "1"));
      localArrayList1.add(new BasicNameValuePair("txtNumID", paramh.f()));
      localArrayList1.add(new BasicNameValuePair("rblTipoCert", "1"));
      localArrayList1.add(new BasicNameValuePair("txtCaptchaHash", "-982750429"));
      localArrayList1.add(new BasicNameValuePair("txtCaptcha", "OHSUVI"));
      localArrayList1.add(new BasicNameValuePair("btnExportar", "Generar"));
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("HANDLE_REDIRECTS_VERIFIQUESE", "SI");
      localHashMap2.put("Connection", "keep-alive");
      localHashMap2.put("Content-Type", "application/x-www-form-urlencoded");
      localHashMap2.put("Accept-Language", "es-ar,es;q=0.8,en-us;q=0.5,en;q=0.3");
      localHashMap2.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      localHashMap2.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:28.0) Gecko/20100101 Firefox/28.0");
      localHashMap2.put("Referer", "http://siri.procuraduria.gov.co:8086/CertWEB/Certificado.aspx?tpo=2");
      localHashMap2.put("Accept-Encoding", "gzip, deflate");
      str5 = se.verifique.app.a.c.a("http://siri.procuraduria.gov.co:8086/CertWEB/Certificado.aspx?tpo=2", 2, localArrayList1, localHashMap1, locale, null, localHashMap2, false, null, false);
      if (("VFQ-TO".equals(str5)) || ("ERROR".equals(str5)))
      {
        System.out.println("Lanzando exception por error");
        throw new a(str5);
      }
    }
    else
    {
      if ("Set-Cookie".equals(locale.a[i].getName()))
        if (locale.a[i].getValue().indexOf(";") <= 0)
          break label761;
      label761: for (String str2 = locale.a[i].getValue().substring(0, locale.a[i].getValue().indexOf(";")); ; str2 = locale.a[i].getValue())
      {
        System.out.println("COOKIE ==> " + str2);
        localHashMap1.put(str2.substring(0, str2.indexOf("=")), str2.substring(1 + str2.indexOf("="), str2.length()));
        i++;
        break;
      }
    }
    System.out.println("PROCURADURIA HTML 2: " + str5);
    System.out.println("INCIA BUSQUEDA PREV");
    String str6 = se.verifique.app.a.c.a(str5, "value=\"(.*?)\" />", 3);
    System.out.println("VIEWSTATE=" + str6);
    String str7 = se.verifique.app.a.c.a(str5, "value=\"(.*?)\" />", 4);
    System.out.println("PREVIOUSPAGE=" + str7);
    String str8 = se.verifique.app.a.c.a(str5, "value=\"(.*?)\" />", 5);
    System.out.println("EVENTVALIDATION=" + str8);
    System.out.println("FINALIZA BUSQUEDA PREV");
    System.out.println("DESCARGAR=" + se.verifique.app.a.c.a(str5, "name=\"btnDescargar\" value=\"(.*?)\" id=\"btnDescargar"));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new BasicNameValuePair("__EVENTTARGET", ""));
    localArrayList2.add(new BasicNameValuePair("__EVENTARGUMENT", ""));
    localArrayList2.add(new BasicNameValuePair("__VIEWSTATE", str6));
    localArrayList2.add(new BasicNameValuePair("__PREVIOUSPAGE", str7));
    localArrayList2.add(new BasicNameValuePair("__EVENTVALIDATION", str8));
    localArrayList2.add(new BasicNameValuePair("btnDescargar", "Descargar"));
    HashMap localHashMap3 = new HashMap();
    localHashMap3.put("HANDLE_REDIRECTS_VERIFIQUESE", "NO");
    localHashMap3.put("Connection", "close");
    localHashMap3.put("Content-Type", "application/x-www-form-urlencoded");
    localHashMap3.put("Host", "siri.procuraduria.gov.co:8086");
    localHashMap3.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:28.0) Gecko/20100101 Firefox/28.0");
    HashMap localHashMap4 = new HashMap();
    localHashMap4.put("VerifiqueseDominio", "siri.procuraduria.gov.co");
    localHashMap4.put("VerifiquesePath", "/");
    int j = 0;
    String str10;
    if (j >= locale.a.length)
    {
      str10 = se.verifique.app.a.c.a("http://siri.procuraduria.gov.co:8086/CertWEB/verpdf.aspx", 2, localArrayList2, localHashMap4, locale, null, localHashMap3, false, null, false);
      if (("VFQ-TO".equals(str10)) || ("ERROR".equals(str10)) || ("ERROR_GUARDANDO_ARCHIVO".equals(str10)))
      {
        System.out.println("Lanzando exception por error");
        throw new a(str10);
      }
    }
    else
    {
      if ("Set-Cookie".equals(locale.a[j].getName()))
        if (locale.a[j].getValue().indexOf(";") <= 0)
          break label1432;
      label1432: for (String str9 = locale.a[j].getValue().substring(0, locale.a[j].getValue().indexOf(";")); ; str9 = locale.a[j].getValue())
      {
        System.out.println("COOKIE ==> " + str9);
        localHashMap4.put(str9.substring(0, str9.indexOf("=")), str9.substring(1 + str9.indexOf("="), str9.length()));
        j++;
        break;
      }
    }
    System.out.println("PROCURADURIA 3: NOMBRE ARCHIVO = " + str10);
    return paramh;
  }

  public h h(h paramh)
  {
    String str1 = se.verifique.app.a.c.a("http://ruafsvr2.sispro.gov.co/RUAF/Cliente/WebPublico/Consultas/D04AfiliacionesPersonaRUAF.aspx", 1, null, null, null, null, null, false, null, false);
    if (("VFQ-TO".equals(str1)) || ("ERROR".equals(str1)))
    {
      System.out.println("Lanzando exception por error");
      throw new a(str1);
    }
    String str2 = se.verifique.app.a.c.a(str1, "<input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"(.*?)\" />");
    System.out.println("VIEWSTATEGENERATOR=" + str2);
    String str3 = se.verifique.app.a.c.a(str1, "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"(.*?)\" />");
    System.out.println("VIEWSTATE=" + str3);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("ctl00$tlkScriptManager", "ctl00$cntContenido$UpdatePanel1|ctl00$cntContenido$btnConsultar"));
    localArrayList.add(new BasicNameValuePair("ctl00_tlkScriptManager_HiddenField", ""));
    localArrayList.add(new BasicNameValuePair("__EVENTTARGET", ""));
    localArrayList.add(new BasicNameValuePair("__EVENTARGUMENT", ""));
    localArrayList.add(new BasicNameValuePair("__VIEWSTATE", str3));
    localArrayList.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", str2));
    localArrayList.add(new BasicNameValuePair("ctl00$cntContenido$ddlTipoIdentificacion", "5"));
    localArrayList.add(new BasicNameValuePair("ctl00$cntContenido$txtNumeroIdentificacion", paramh.f()));
    localArrayList.add(new BasicNameValuePair("__ASYNCPOST", "true"));
    localArrayList.add(new BasicNameValuePair("ctl00$cntContenido$btnConsultar", "Consultar"));
    e locale = new e(this);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("HANDLE_REDIRECTS_VERIFIQUESE", "NO");
    localHashMap1.put("X-MicrosoftAjax", "Delta=true");
    localHashMap1.put("Accept-Language", "es-''ar,es;q=0.8,en-us;q=0.5,en;q=0.3");
    localHashMap1.put("X-Requested-With", "XMLHttpRequest");
    localHashMap1.put("Referer", "http://ruafsvr2.sispro.gov.co/RUAF/Cliente/WebPublico/Consultas/D04AfiliacionesPersonaRUAF.aspx");
    localHashMap1.put("Accept-Encoding", "gzip, deflate");
    localHashMap1.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:30.0) Gecko/20100101 Firefox/30.0");
    localHashMap1.put("Connection", "keep-alive");
    localHashMap1.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
    localHashMap1.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    localHashMap1.put("Cache-Control", "no-cache");
    localHashMap1.put("Pragma", "no-cache");
    String str4 = se.verifique.app.a.c.a("http://ruafsvr2.sispro.gov.co/RUAF/Cliente/WebPublico/Consultas/D04AfiliacionesPersonaRUAF.aspx", 2, localArrayList, null, locale, null, localHashMap1, false, null, false);
    if (("VFQ-TO".equals(str4)) || ("ERROR".equals(str4)))
    {
      System.out.println("Lanzando exception por error");
      throw new a(str4);
    }
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("VerifiqueseDominio", "ruafsvr2.sispro.gov.co");
    localHashMap2.put("VerifiquesePath", "/");
    int i = 0;
    String str6;
    String str7;
    if (i >= locale.a.length)
    {
      str6 = se.verifique.app.a.c.a(str4, "GUID=(.*?)\"");
      System.out.println("GUID=" + str6);
      new ArrayList().add(new BasicNameValuePair("GUID", str6));
      HashMap localHashMap3 = new HashMap();
      localHashMap3.put("HANDLE_REDIRECTS_VERIFIQUESE", "NO");
      localHashMap3.put("Accept-Language", "es-ar,es;q=0.8,en-us;q=0.5,en;q=0.3");
      localHashMap3.put("Referer", "http://ruafsvr2.sispro.gov.co/RUAF/Cliente/WebPublico/Consultas/D04AfiliacionesPersonaRUAF.aspx");
      localHashMap3.put("Accept-Encoding", "gzip, deflate");
      localHashMap3.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:30.0) Gecko/20100101 Firefox/30.0");
      localHashMap3.put("Connection", "close");
      localHashMap3.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      str7 = se.verifique.app.a.c.a("http://ruafsvr2.sispro.gov.co/RUAF/Cliente/WebPublico/Visor/frmVisorReporte.aspx?GUID=" + str6, 1, null, localHashMap2, null, null, localHashMap3, false, null, false);
      if (("VFQ-TO".equals(str7)) || ("ERROR".equals(str7)))
      {
        System.out.println("Lanzando exception por error");
        throw new a(str7);
      }
    }
    else
    {
      if ("Set-Cookie".equals(locale.a[i].getName()))
        if (locale.a[i].getValue().indexOf(";") <= 0)
          break label1002;
      label1002: for (String str5 = locale.a[i].getValue().substring(0, locale.a[i].getValue().indexOf(";")); ; str5 = locale.a[i].getValue())
      {
        System.out.println("COOKIE ==> " + str5);
        localHashMap2.put(str5.substring(0, str5.indexOf("=")), str5.substring(1 + str5.indexOf("="), str5.length()));
        i++;
        break;
      }
    }
    String str8 = se.verifique.app.a.c.a(str7, "ReportSession=(.*?)&");
    System.out.println("ReportSession=" + str8);
    String str9 = se.verifique.app.a.c.a(str7, "ControlID=(.*?)&");
    System.out.println("ControlID=" + str9);
    HashMap localHashMap4 = new HashMap();
    localHashMap4.put("HANDLE_REDIRECTS_VERIFIQUESE", "NO");
    localHashMap4.put("Accept-Language", "es-ar,es;q=0.8,en-us;q=0.5,en;q=0.3");
    localHashMap4.put("Referer", "http://ruafsvr2.sispro.gov.co/RUAF/Cliente/WebPublico/Visor/frmVisorReporte.aspx?GUID=" + str6);
    localHashMap4.put("Accept-Encoding", "gzip, deflate");
    localHashMap4.put("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:30.0) Gecko/20100101 Firefox/30.0");
    localHashMap4.put("Connection", "close");
    localHashMap4.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    HashMap localHashMap5 = new HashMap();
    localHashMap5.put("VerifiqueseDominio", "ruafsvr2.sispro.gov.co");
    localHashMap5.put("VerifiquesePath", "/");
    int j = 0;
    String str11;
    if (j >= locale.a.length)
    {
      str11 = se.verifique.app.a.c.a("http://ruafsvr2.sispro.gov.co/RUAF/Cliente/WebPublico/Reserved.ReportViewerWebControl.axd?ReportSession=" + str8 + "&" + "ControlID=" + str9 + "&" + "Culture=9226" + "&" + "UICulture=9226" + "&" + "ReportStack=1" + "&" + "OpType=Export" + "&" + "FileName=D04AfiliacionesPersonaRUAF" + "&" + "ContentDisposition=OnlyHtmlInline" + "&" + "Format=XML", 1, null, localHashMap5, null, null, localHashMap4, false, null, false);
      if (("VFQ-TO".equals(str11)) || ("ERROR".equals(str11)))
      {
        System.out.println("Lanzando exception por error");
        throw new a(str11);
      }
    }
    else
    {
      if ("Set-Cookie".equals(locale.a[j].getName()))
        if (locale.a[j].getValue().indexOf(";") <= 0)
          break label1581;
      label1581: for (String str10 = locale.a[j].getValue().substring(0, locale.a[j].getValue().indexOf(";")); ; str10 = locale.a[j].getValue())
      {
        System.out.println("COOKIE ==> " + str10);
        localHashMap5.put(str10.substring(0, str10.indexOf("=")), str10.substring(1 + str10.indexOf("="), str10.length()));
        j++;
        break;
      }
    }
    paramh.a(new j(str11).a());
    return paramh;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.util.d
 * JD-Core Version:    0.6.0
 */