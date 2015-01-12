package com.ubercab.analytics.internal.writers;

import com.squareup.javawriter.JavaWriter;
import com.ubercab.analytics.annotations.AnalyticsName;
import com.ubercab.analytics.internal.ProcessorUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class UberSupportViewWriter
  implements AnalyticsWriter
{
  private static final String EVENT_STATEMENT = "container.%s.addOnClickListener(new View.OnClickListener() {\n@Override public void onClick(View view) {\nAnalytics.getInstance().getAnalyticsClient().sendTapEvent(\"%s\");\n}\n})";
  static final String UBER_VIEW_SUPPORT_CLASS = "com.ubercab.ui.UberViewSupport";
  static final String UBER_VIEW_SUPPORT_CLASS_NAME = "UberViewSupport";
  private Element mElement;

  public UberSupportViewWriter(Element paramElement)
  {
    this.mElement = paramElement;
  }

  public static boolean accepts(Element paramElement, ProcessorUtils paramProcessorUtils)
  {
    TypeMirror localTypeMirror = paramProcessorUtils.getElementUtils().getTypeElement("com.ubercab.ui.UberViewSupport").asType();
    return paramProcessorUtils.getTypeUtils().isAssignable(paramElement.asType(), localTypeMirror);
  }

  public static List<String> getImports()
  {
    return Collections.singletonList("com.ubercab.ui.UberViewSupport");
  }

  public static void validate(Element paramElement, ProcessorUtils paramProcessorUtils)
  {
    int i;
    if (!paramElement.getModifiers().contains(Integer.valueOf(2)))
    {
      i = 1;
      if ((i == 0) || (!paramElement.getKind().isField()))
        break label59;
    }
    label59: for (int j = 1; ; j = 0)
    {
      if (j == 0)
        paramProcessorUtils.error(paramElement, "Must be a field that implements UberViewSupport and cannot be private.", new Object[0]);
      return;
      i = 0;
      break;
    }
  }

  public void emitStatements(JavaWriter paramJavaWriter)
    throws IOException
  {
    String str = ((AnalyticsName)this.mElement.getAnnotation(AnalyticsName.class)).value();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.mElement.toString();
    arrayOfObject[1] = str;
    paramJavaWriter.emitStatement("container.%s.addOnClickListener(new View.OnClickListener() {\n@Override public void onClick(View view) {\nAnalytics.getInstance().getAnalyticsClient().sendTapEvent(\"%s\");\n}\n})", arrayOfObject);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.analytics.internal.writers.UberSupportViewWriter
 * JD-Core Version:    0.6.2
 */