package se.verifique.app.cedula.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class j
{
  k a;

  public j(String paramString)
  {
    while (true)
    {
      int j;
      int k;
      int m;
      int n;
      int i1;
      int i2;
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramString.getBytes("UTF-8"));
        Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(localByteArrayInputStream);
        localDocument.getDocumentElement().normalize();
        this.a = new k();
        this.a.a(new l());
        List localList1 = this.a.a().a();
        m localm = new m();
        localList1.add(localm);
        z localz = new z();
        localm.a(localz);
        localz.a(new aa());
        List localList2 = localz.a().a();
        System.out.println("ROOT (Debe ser Report)=" + localDocument.getDocumentElement().getNodeName());
        NodeList localNodeList1 = localDocument.getElementsByTagName("tblPersona_grpPersona");
        System.out.println("----------------------------");
        j = 0;
        if (j < localNodeList1.getLength())
          continue;
        w localw = new w();
        localm.a(localw);
        localw.a(new x());
        List localList3 = localw.a().a();
        NodeList localNodeList2 = localDocument.getElementsByTagName("tblPensiones_grpPensiones");
        k = 0;
        if (k < localNodeList2.getLength())
          continue;
        ac localac = new ac();
        localm.a(localac);
        localac.a(new ad());
        List localList4 = localac.a().a();
        NodeList localNodeList3 = localDocument.getElementsByTagName("tblRiesgosProfesionales_grpRiegosProfesionales");
        m = 0;
        if (m < localNodeList3.getLength())
          continue;
        q localq = new q();
        localm.a(localq);
        localq.a(new r());
        List localList5 = localq.a().a();
        NodeList localNodeList4 = localDocument.getElementsByTagName("tblCompensacionFamiliar_grpCompensacionFamiliar");
        n = 0;
        if (n < localNodeList4.getLength())
          continue;
        n localn = new n();
        localm.a(localn);
        localn.a(new o());
        List localList6 = localn.a().a();
        NodeList localNodeList5 = localDocument.getElementsByTagName("tblCesantias_grpCesantias");
        i1 = 0;
        if (i1 < localNodeList5.getLength())
          continue;
        af localaf = new af();
        localm.a(localaf);
        localaf.a(new ag());
        List localList7 = localaf.a().a();
        NodeList localNodeList6 = localDocument.getElementsByTagName("tblSL_grpSL");
        i2 = 0;
        if (i2 < localNodeList6.getLength())
          continue;
        t localt = new t();
        localm.a(localt);
        localt.a(new u());
        List localList8 = localt.a().a();
        NodeList localNodeList7 = localDocument.getElementsByTagName("tblPensionados_grpPensionados");
        if (i < localNodeList7.getLength())
          continue;
        break label1694;
        Node localNode7 = localNodeList1.item(j);
        System.out.println("\nCurrent Element :" + localNode7.getNodeName());
        if (localNode7.getNodeType() != 1)
          break label1695;
        Element localElement7 = (Element)localNode7;
        ab localab = new ab();
        localList2.add(localab);
        localab.b(localElement7.getAttribute("PrimerNombre"));
        localab.c(localElement7.getAttribute("Sexo"));
        localab.a(localElement7.getAttribute("TipoIdentificacion"));
        System.out.println("Identificacion : " + localElement7.getAttribute("TipoIdentificacion"));
        System.out.println("PrimerNombre : " + localElement7.getAttribute("PrimerNombre"));
        System.out.println("Sexo : " + localElement7.getAttribute("Sexo"));
        break label1695;
        Node localNode6 = localNodeList2.item(k);
        if (localNode6.getNodeType() != 1)
          break label1701;
        Element localElement6 = (Element)localNode6;
        y localy = new y();
        localList3.add(localy);
        localy.e(localElement6.getAttribute("textbox39"));
        localy.c(localElement6.getAttribute("textbox20"));
        localy.d(localElement6.getAttribute("textbox18"));
        localy.b(localElement6.getAttribute("textbox17"));
        localy.a(localElement6.getAttribute("textbox16"));
        break label1701;
        Node localNode5 = localNodeList3.item(m);
        if (localNode5.getNodeType() != 1)
          break label1707;
        Element localElement5 = (Element)localNode5;
        ae localae = new ae();
        localList4.add(localae);
        localae.c(localElement5.getAttribute("textbox51"));
        localae.e(localElement5.getAttribute("textbox50"));
        localae.b(localElement5.getAttribute("textbox49"));
        localae.a(localElement5.getAttribute("textbox48"));
        localae.f(localElement5.getAttribute("textbox47"));
        localae.d(localElement5.getAttribute("DepartamentoLaboralRP"));
        break label1707;
        Node localNode4 = localNodeList4.item(n);
        if (localNode4.getNodeType() != 1)
          break label1713;
        Element localElement4 = (Element)localNode4;
        s locals = new s();
        localList5.add(locals);
        locals.b(localElement4.getAttribute("DepartamentoLaboralCF"));
        locals.a(localElement4.getAttribute("TipoAfiliadoCF"));
        locals.f(localElement4.getAttribute("TipoMPCCF"));
        locals.d(localElement4.getAttribute("textbox61"));
        locals.c(localElement4.getAttribute("textbox60"));
        locals.e(localElement4.getAttribute("textbox59"));
        break label1713;
        Node localNode3 = localNodeList5.item(i1);
        if (localNode3.getNodeType() != 1)
          break label1719;
        Element localElement3 = (Element)localNode3;
        p localp = new p();
        localList6.add(localp);
        localp.a(localElement3.getAttribute("textbox90"));
        localp.b(localElement3.getAttribute("textbox91"));
        localp.c(localElement3.getAttribute("textbox92"));
        localp.d(localElement3.getAttribute("textbox93"));
        localp.e(localElement3.getAttribute("textbox94"));
        break label1719;
        Node localNode2 = localNodeList6.item(i2);
        if (localNode2.getNodeType() != 1)
          break label1725;
        Element localElement2 = (Element)localNode2;
        ah localah = new ah();
        localList7.add(localah);
        localah.b(localElement2.getAttribute("AdministradoraSL"));
        localah.d(localElement2.getAttribute("EstadoAfiliadoSL"));
        localah.c(localElement2.getAttribute("FechaAfiliacionSL"));
        localah.a(localElement2.getAttribute("RegimenSL"));
        localah.f(localElement2.getAttribute("textbox81"));
        localah.e(localElement2.getAttribute("TipoAfiliadoSL"));
        break label1725;
        Node localNode1 = localNodeList7.item(i);
        if (localNode1.getNodeType() != 1)
          continue;
        Element localElement1 = (Element)localNode1;
        v localv = new v();
        localList8.add(localv);
        localv.h(localElement1.getAttribute("ModalidadPensionPG"));
        localv.a(localElement1.getAttribute("NumeroResolucionPensionPG"));
        localv.b(localElement1.getAttribute("PensionCompartidaPG"));
        localv.f(localElement1.getAttribute("textbox62"));
        localv.g(localElement1.getAttribute("textbox63"));
        localv.c(localElement1.getAttribute("textbox69"));
        localv.d(localElement1.getAttribute("textbox70"));
        localv.e(localElement1.getAttribute("textbox71"));
        i++;
        continue;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      catch (SAXException localSAXException)
      {
        localSAXException.printStackTrace();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      catch (ParserConfigurationException localParserConfigurationException)
      {
        localParserConfigurationException.printStackTrace();
      }
      label1694: return;
      label1695: j++;
      continue;
      label1701: k++;
      continue;
      label1707: m++;
      continue;
      label1713: n++;
      continue;
      label1719: i1++;
      continue;
      label1725: i2++;
    }
  }

  public k a()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.a.j
 * JD-Core Version:    0.6.0
 */