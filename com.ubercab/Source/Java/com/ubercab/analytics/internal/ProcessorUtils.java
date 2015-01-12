package com.ubercab.analytics.internal;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic.Kind;

public class ProcessorUtils
{
  private Elements mElementUtils;
  private ProcessingEnvironment mProcessingEnvironment;
  private Types mTypeUtils;

  public ProcessorUtils(ProcessingEnvironment paramProcessingEnvironment)
  {
    this.mProcessingEnvironment = paramProcessingEnvironment;
    this.mElementUtils = paramProcessingEnvironment.getElementUtils();
    this.mTypeUtils = paramProcessingEnvironment.getTypeUtils();
  }

  public void error(Element paramElement, String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length > 0)
      paramString = String.format(paramString, paramArrayOfObject);
    this.mProcessingEnvironment.getMessager().printMessage(Diagnostic.Kind.ERROR, paramString, paramElement);
  }

  public String getClassName(TypeElement paramTypeElement)
  {
    int i = 1 + getPackageName(paramTypeElement).length();
    return paramTypeElement.getQualifiedName().toString().substring(i).replace('.', '$');
  }

  public Elements getElementUtils()
  {
    return this.mElementUtils;
  }

  public String getPackageName(TypeElement paramTypeElement)
  {
    return this.mElementUtils.getPackageOf(paramTypeElement).getQualifiedName().toString();
  }

  public ProcessingEnvironment getProcessingEnvironment()
  {
    return this.mProcessingEnvironment;
  }

  public Types getTypeUtils()
  {
    return this.mTypeUtils;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.analytics.internal.ProcessorUtils
 * JD-Core Version:    0.6.2
 */