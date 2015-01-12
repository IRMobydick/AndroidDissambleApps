package butterknife.internal;

import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnItemSelected;
import butterknife.OnLongClick;
import butterknife.OnPageChange;
import butterknife.OnTextChanged;
import butterknife.OnTouch;
import butterknife.Optional;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

public final class ButterKnifeProcessor extends AbstractProcessor
{
  private static final List<Class<? extends Annotation>> LISTENERS;
  private static final String LIST_TYPE;
  public static final String SUFFIX = "$$ViewInjector";
  static final String VIEW_TYPE = "android.view.View";
  private Elements elementUtils;
  private Filer filer;
  private Types typeUtils;

  static
  {
    if (!ButterKnifeProcessor.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      LIST_TYPE = List.class.getCanonicalName();
      LISTENERS = Arrays.asList(new Class[] { OnCheckedChanged.class, OnClick.class, OnEditorAction.class, OnFocusChange.class, OnItemClick.class, OnItemLongClick.class, OnItemSelected.class, OnLongClick.class, OnPageChange.class, OnTextChanged.class, OnTouch.class });
      return;
    }
  }

  private String doubleErasure(TypeMirror paramTypeMirror)
  {
    String str = this.typeUtils.erasure(paramTypeMirror).toString();
    int i = str.indexOf('<');
    if (i != -1)
      str = str.substring(0, i);
    return str;
  }

  private void error(Element paramElement, String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length > 0)
      paramString = String.format(paramString, paramArrayOfObject);
    this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, paramString, paramElement);
  }

  private void findAndParseListener(RoundEnvironment paramRoundEnvironment, Class<? extends Annotation> paramClass, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet)
  {
    Iterator localIterator = paramRoundEnvironment.getElementsAnnotatedWith(paramClass).iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      try
      {
        parseListenerAnnotation(paramClass, localElement, paramMap, paramSet);
      }
      catch (Exception localException)
      {
        StringWriter localStringWriter = new StringWriter();
        localException.printStackTrace(new PrintWriter(localStringWriter));
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramClass.getSimpleName();
        arrayOfObject[1] = localStringWriter.toString();
        error(localElement, "Unable to generate view injector for @%s.\n\n%s", arrayOfObject);
      }
    }
  }

  private Map<TypeElement, ViewInjector> findAndParseTargets(RoundEnvironment paramRoundEnvironment)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator1 = paramRoundEnvironment.getElementsAnnotatedWith(InjectView.class).iterator();
    while (localIterator1.hasNext())
    {
      Element localElement2 = (Element)localIterator1.next();
      try
      {
        parseInjectView(localElement2, localLinkedHashMap, localLinkedHashSet);
      }
      catch (Exception localException2)
      {
        StringWriter localStringWriter2 = new StringWriter();
        localException2.printStackTrace(new PrintWriter(localStringWriter2));
        error(localElement2, "Unable to generate view injector for @InjectView.\n\n%s", new Object[] { localStringWriter2 });
      }
    }
    Iterator localIterator2 = paramRoundEnvironment.getElementsAnnotatedWith(InjectViews.class).iterator();
    while (localIterator2.hasNext())
    {
      Element localElement1 = (Element)localIterator2.next();
      try
      {
        parseInjectViews(localElement1, localLinkedHashMap, localLinkedHashSet);
      }
      catch (Exception localException1)
      {
        StringWriter localStringWriter1 = new StringWriter();
        localException1.printStackTrace(new PrintWriter(localStringWriter1));
        error(localElement1, "Unable to generate view injector for @InjectViews.\n\n%s", new Object[] { localStringWriter1 });
      }
    }
    Iterator localIterator3 = LISTENERS.iterator();
    while (localIterator3.hasNext())
      findAndParseListener(paramRoundEnvironment, (Class)localIterator3.next(), localLinkedHashMap, localLinkedHashSet);
    Iterator localIterator4 = localLinkedHashMap.entrySet().iterator();
    while (localIterator4.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator4.next();
      String str = findParentFqcn((TypeElement)localEntry.getKey(), localLinkedHashSet);
      if (str != null)
        ((ViewInjector)localEntry.getValue()).setParentInjector(str + "$$ViewInjector");
    }
    return localLinkedHashMap;
  }

  private String findParentFqcn(TypeElement paramTypeElement, Set<String> paramSet)
  {
    do
    {
      TypeMirror localTypeMirror = paramTypeElement.getSuperclass();
      if (localTypeMirror.getKind() == TypeKind.NONE)
        return null;
      paramTypeElement = (TypeElement)((DeclaredType)localTypeMirror).asElement();
    }
    while (!paramSet.contains(paramTypeElement.toString()));
    String str = getPackageName(paramTypeElement);
    return str + "." + getClassName(paramTypeElement, str);
  }

  private static String getClassName(TypeElement paramTypeElement, String paramString)
  {
    int i = 1 + paramString.length();
    return paramTypeElement.getQualifiedName().toString().substring(i).replace('.', '$');
  }

  private ViewInjector getOrCreateTargetClass(Map<TypeElement, ViewInjector> paramMap, TypeElement paramTypeElement)
  {
    ViewInjector localViewInjector = (ViewInjector)paramMap.get(paramTypeElement);
    if (localViewInjector == null)
    {
      String str1 = paramTypeElement.getQualifiedName().toString();
      String str2 = getPackageName(paramTypeElement);
      localViewInjector = new ViewInjector(str2, getClassName(paramTypeElement, str2) + "$$ViewInjector", str1);
      paramMap.put(paramTypeElement, localViewInjector);
    }
    return localViewInjector;
  }

  private String getPackageName(TypeElement paramTypeElement)
  {
    return this.elementUtils.getPackageOf(paramTypeElement).getQualifiedName().toString();
  }

  private boolean isSubtypeOfType(TypeMirror paramTypeMirror, String paramString)
  {
    if (paramString.equals(paramTypeMirror.toString()));
    TypeElement localTypeElement;
    do
    {
      DeclaredType localDeclaredType;
      StringBuilder localStringBuilder;
      do
      {
        return true;
        if (!(paramTypeMirror instanceof DeclaredType))
          return false;
        localDeclaredType = (DeclaredType)paramTypeMirror;
        List localList = localDeclaredType.getTypeArguments();
        if (localList.size() <= 0)
          break;
        localStringBuilder = new StringBuilder(localDeclaredType.asElement().toString());
        localStringBuilder.append('<');
        for (int i = 0; i < localList.size(); i++)
        {
          if (i > 0)
            localStringBuilder.append(',');
          localStringBuilder.append('?');
        }
        localStringBuilder.append('>');
      }
      while (localStringBuilder.toString().equals(paramString));
      Element localElement = localDeclaredType.asElement();
      if (!(localElement instanceof TypeElement))
        return false;
      localTypeElement = (TypeElement)localElement;
    }
    while (isSubtypeOfType(localTypeElement.getSuperclass(), paramString));
    Iterator localIterator = localTypeElement.getInterfaces().iterator();
    while (localIterator.hasNext())
      if (isSubtypeOfType((TypeMirror)localIterator.next(), paramString))
        return true;
    return false;
  }

  private boolean isValidForGeneratedCode(Class<? extends Annotation> paramClass, String paramString, Element paramElement)
  {
    TypeElement localTypeElement = (TypeElement)paramElement.getEnclosingElement();
    Set localSet = paramElement.getModifiers();
    boolean bool1;
    if (!localSet.contains(Modifier.PRIVATE))
    {
      boolean bool2 = localSet.contains(Modifier.STATIC);
      bool1 = false;
      if (!bool2);
    }
    else
    {
      Object[] arrayOfObject1 = new Object[4];
      arrayOfObject1[0] = paramClass.getSimpleName();
      arrayOfObject1[1] = paramString;
      arrayOfObject1[2] = localTypeElement.getQualifiedName();
      arrayOfObject1[3] = paramElement.getSimpleName();
      error(paramElement, "@%s %s must not be private or static. (%s.%s)", arrayOfObject1);
      bool1 = true;
    }
    if (localTypeElement.getKind() != ElementKind.CLASS)
    {
      Object[] arrayOfObject3 = new Object[4];
      arrayOfObject3[0] = paramClass.getSimpleName();
      arrayOfObject3[1] = paramString;
      arrayOfObject3[2] = localTypeElement.getQualifiedName();
      arrayOfObject3[3] = paramElement.getSimpleName();
      error(localTypeElement, "@%s %s may only be contained in classes. (%s.%s)", arrayOfObject3);
      bool1 = true;
    }
    if (localTypeElement.getModifiers().contains(Modifier.PRIVATE))
    {
      Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = paramClass.getSimpleName();
      arrayOfObject2[1] = paramString;
      arrayOfObject2[2] = localTypeElement.getQualifiedName();
      arrayOfObject2[3] = paramElement.getSimpleName();
      error(localTypeElement, "@%s %s may not be contained in private classes. (%s.%s)", arrayOfObject2);
      bool1 = true;
    }
    return bool1;
  }

  private void parseInjectView(Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet)
  {
    TypeElement localTypeElement = (TypeElement)paramElement.getEnclosingElement();
    TypeMirror localTypeMirror = paramElement.asType();
    if ((localTypeMirror instanceof TypeVariable))
      localTypeMirror = ((TypeVariable)localTypeMirror).getUpperBound();
    boolean bool1 = isSubtypeOfType(localTypeMirror, "android.view.View");
    int i = 0;
    if (!bool1)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localTypeElement.getQualifiedName();
      arrayOfObject2[1] = paramElement.getSimpleName();
      error(paramElement, "@InjectView fields must extend from View. (%s.%s)", arrayOfObject2);
      i = 1;
    }
    boolean bool2 = i | isValidForGeneratedCode(InjectView.class, "fields", paramElement);
    if (paramElement.getAnnotation(InjectViews.class) != null)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = localTypeElement.getQualifiedName();
      arrayOfObject1[1] = paramElement.getSimpleName();
      error(paramElement, "Only one of @InjectView and @InjectViews is allowed. (%s.%s)", arrayOfObject1);
      bool2 = true;
    }
    if (bool2)
      return;
    String str1 = paramElement.getSimpleName().toString();
    int j = ((InjectView)paramElement.getAnnotation(InjectView.class)).value();
    String str2 = localTypeMirror.toString();
    if (paramElement.getAnnotation(Optional.class) == null);
    for (boolean bool3 = true; ; bool3 = false)
    {
      getOrCreateTargetClass(paramMap, localTypeElement).addView(j, new ViewBinding(str1, str2, bool3));
      paramSet.add(localTypeElement.toString());
      return;
    }
  }

  private void parseInjectViews(Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet)
  {
    int i = 0;
    TypeElement localTypeElement = (TypeElement)paramElement.getEnclosingElement();
    TypeMirror localTypeMirror1 = paramElement.asType();
    String str1 = doubleErasure(localTypeMirror1);
    TypeMirror localTypeMirror2 = null;
    CollectionBinding.Kind localKind;
    if (localTypeMirror1.getKind() == TypeKind.ARRAY)
    {
      localTypeMirror2 = ((ArrayType)localTypeMirror1).getComponentType();
      localKind = CollectionBinding.Kind.ARRAY;
    }
    while (true)
    {
      if ((localTypeMirror2 instanceof TypeVariable))
        localTypeMirror2 = ((TypeVariable)localTypeMirror2).getUpperBound();
      if ((localTypeMirror2 != null) && (!isSubtypeOfType(localTypeMirror2, "android.view.View")))
      {
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = localTypeElement.getQualifiedName();
        arrayOfObject3[1] = paramElement.getSimpleName();
        error(paramElement, "@InjectViews type must extend from View. (%s.%s)", arrayOfObject3);
        i = 1;
      }
      if ((i | isValidForGeneratedCode(InjectViews.class, "fields", paramElement)) == 0)
        break;
      return;
      if (LIST_TYPE.equals(str1))
      {
        List localList = ((DeclaredType)localTypeMirror1).getTypeArguments();
        if (localList.size() != 1)
        {
          Object[] arrayOfObject4 = new Object[2];
          arrayOfObject4[0] = localTypeElement.getQualifiedName();
          arrayOfObject4[1] = paramElement.getSimpleName();
          error(paramElement, "@InjectViews List must have a generic component. (%s.%s)", arrayOfObject4);
        }
        for (i = 1; ; i = 0)
        {
          localKind = CollectionBinding.Kind.LIST;
          break;
          localTypeMirror2 = (TypeMirror)localList.get(0);
        }
      }
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = localTypeElement.getQualifiedName();
      arrayOfObject1[1] = paramElement.getSimpleName();
      error(paramElement, "@InjectViews must be a List or array. (%s.%s)", arrayOfObject1);
      i = 1;
      localKind = null;
      localTypeMirror2 = null;
    }
    String str2 = paramElement.getSimpleName().toString();
    int[] arrayOfInt = ((InjectViews)paramElement.getAnnotation(InjectViews.class)).value();
    if (arrayOfInt.length == 0)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localTypeElement.getQualifiedName();
      arrayOfObject2[1] = paramElement.getSimpleName();
      error(paramElement, "@InjectViews must specify at least one ID. (%s.%s)", arrayOfObject2);
      return;
    }
    assert (localTypeMirror2 != null);
    String str3 = localTypeMirror2.toString();
    if (paramElement.getAnnotation(Optional.class) == null);
    for (boolean bool = true; ; bool = false)
    {
      getOrCreateTargetClass(paramMap, localTypeElement).addCollection(arrayOfInt, new CollectionBinding(str2, str3, localKind, bool));
      paramSet.add(localTypeElement.toString());
      return;
    }
  }

  private void parseListenerAnnotation(Class<? extends Annotation> paramClass, Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet)
    throws Exception
  {
    if ((!(paramElement instanceof ExecutableElement)) || (paramElement.getKind() != ElementKind.METHOD))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramClass.getSimpleName();
      throw new IllegalStateException(String.format("@%s annotation must be on a method.", arrayOfObject1));
    }
    ExecutableElement localExecutableElement = (ExecutableElement)paramElement;
    TypeElement localTypeElement = (TypeElement)paramElement.getEnclosingElement();
    Annotation localAnnotation = paramElement.getAnnotation(paramClass);
    Method localMethod = paramClass.getDeclaredMethod("value", new Class[0]);
    if (localMethod.getReturnType() != [I.class)
      throw new IllegalStateException(String.format("@%s annotation value() type not int[].", new Object[] { paramClass }));
    int[] arrayOfInt = (int[])localMethod.invoke(localAnnotation, new Object[0]);
    String str1 = localExecutableElement.getSimpleName().toString();
    if (paramElement.getAnnotation(Optional.class) == null);
    boolean bool2;
    for (boolean bool1 = true; ; bool1 = false)
    {
      bool2 = isValidForGeneratedCode(paramClass, "methods", paramElement);
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      int i = arrayOfInt.length;
      for (int j = 0; j < i; j++)
      {
        int i8 = arrayOfInt[j];
        if (!localLinkedHashSet.add(Integer.valueOf(i8)))
        {
          Object[] arrayOfObject9 = new Object[4];
          arrayOfObject9[0] = paramClass.getSimpleName();
          arrayOfObject9[1] = Integer.valueOf(i8);
          arrayOfObject9[2] = localTypeElement.getQualifiedName();
          arrayOfObject9[3] = paramElement.getSimpleName();
          error(paramElement, "@%s annotation for method contains duplicate ID %d. (%s.%s)", arrayOfObject9);
          bool2 = true;
        }
      }
    }
    ListenerClass localListenerClass = (ListenerClass)paramClass.getAnnotation(ListenerClass.class);
    if (localListenerClass == null)
    {
      Object[] arrayOfObject8 = new Object[2];
      arrayOfObject8[0] = ListenerClass.class.getSimpleName();
      arrayOfObject8[1] = paramClass.getSimpleName();
      throw new IllegalStateException(String.format("No @%s defined on @%s.", arrayOfObject8));
    }
    ListenerMethod[] arrayOfListenerMethod = localListenerClass.method();
    if (arrayOfListenerMethod.length > 1)
    {
      Object[] arrayOfObject7 = new Object[1];
      arrayOfObject7[0] = paramClass.getSimpleName();
      throw new IllegalStateException(String.format("Multiple listener methods specified on @%s.", arrayOfObject7));
    }
    ListenerMethod localListenerMethod;
    if (arrayOfListenerMethod.length == 1)
    {
      if (localListenerClass.callbacks() != ListenerClass.NONE.class)
      {
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = paramClass.getSimpleName();
        throw new IllegalStateException(String.format("Both method() and callback() defined on @%s.", arrayOfObject6));
      }
      localListenerMethod = arrayOfListenerMethod[0];
    }
    List localList;
    Enum localEnum;
    do
    {
      localList = localExecutableElement.getParameters();
      if (localList.size() > localListenerMethod.parameters().length)
      {
        Object[] arrayOfObject5 = new Object[4];
        arrayOfObject5[0] = paramClass.getSimpleName();
        arrayOfObject5[1] = Integer.valueOf(localListenerMethod.parameters().length);
        arrayOfObject5[2] = localTypeElement.getQualifiedName();
        arrayOfObject5[3] = paramElement.getSimpleName();
        error(paramElement, "@%s methods can have at most %s parameter(s). (%s.%s)", arrayOfObject5);
        bool2 = true;
      }
      TypeMirror localTypeMirror1 = localExecutableElement.getReturnType();
      if ((localTypeMirror1 instanceof TypeVariable))
        localTypeMirror1 = ((TypeVariable)localTypeMirror1).getUpperBound();
      if (!localTypeMirror1.toString().equals(localListenerMethod.returnType()))
      {
        Object[] arrayOfObject4 = new Object[4];
        arrayOfObject4[0] = paramClass.getSimpleName();
        arrayOfObject4[1] = localListenerMethod.returnType();
        arrayOfObject4[2] = localTypeElement.getQualifiedName();
        arrayOfObject4[3] = paramElement.getSimpleName();
        error(paramElement, "@%s methods must have a '%s' return type. (%s.%s)", arrayOfObject4);
        bool2 = true;
      }
      if (!bool2)
        break;
      return;
      localEnum = (Enum)paramClass.getDeclaredMethod("callback", new Class[0]).invoke(localAnnotation, new Object[0]);
      localListenerMethod = (ListenerMethod)localEnum.getDeclaringClass().getField(localEnum.name()).getAnnotation(ListenerMethod.class);
    }
    while (localListenerMethod != null);
    Object[] arrayOfObject2 = new Object[4];
    arrayOfObject2[0] = ListenerMethod.class.getSimpleName();
    arrayOfObject2[1] = paramClass.getSimpleName();
    arrayOfObject2[2] = localEnum.getDeclaringClass().getSimpleName();
    arrayOfObject2[3] = localEnum.name();
    throw new IllegalStateException(String.format("No @%s defined on @%s's %s.%s.", arrayOfObject2));
    Parameter[] arrayOfParameter = Parameter.NONE;
    if (!localList.isEmpty())
    {
      arrayOfParameter = new Parameter[localList.size()];
      BitSet localBitSet = new BitSet(localList.size());
      String[] arrayOfString1 = localListenerMethod.parameters();
      for (int i1 = 0; i1 < localList.size(); i1++)
      {
        TypeMirror localTypeMirror2 = ((VariableElement)localList.get(i1)).asType();
        if ((localTypeMirror2 instanceof TypeVariable))
          localTypeMirror2 = ((TypeVariable)localTypeMirror2).getUpperBound();
        int i2 = 0;
        int i3 = arrayOfString1.length;
        if (i2 < i3)
        {
          if (localBitSet.get(i2));
          String str3;
          do
          {
            i2++;
            break;
            str3 = arrayOfString1[i2];
          }
          while (!isSubtypeOfType(localTypeMirror2, str3));
          String str4 = localTypeMirror2.toString();
          Parameter localParameter2 = new Parameter(i2, str4);
          arrayOfParameter[i1] = localParameter2;
          localBitSet.set(i2);
        }
        if (arrayOfParameter[i1] == null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to match @").append(paramClass.getSimpleName()).append(" method arguments. (").append(localTypeElement.getQualifiedName()).append('.').append(paramElement.getSimpleName()).append(')');
          int i4 = 0;
          int i5 = arrayOfParameter.length;
          if (i4 < i5)
          {
            Parameter localParameter1 = arrayOfParameter[i4];
            localStringBuilder.append("\n\n  Parameter #").append(i4 + 1).append(": ").append(((VariableElement)localList.get(i4)).asType().toString()).append("\n    ");
            if (localParameter1 == null)
              localStringBuilder.append("did not match any listener parameters");
            while (true)
            {
              i4++;
              break;
              localStringBuilder.append("matched listener parameter #").append(1 + localParameter1.getListenerPosition()).append(": ").append(localParameter1.getType());
            }
          }
          localStringBuilder.append("\n\nMethods may have up to ").append(localListenerMethod.parameters().length).append(" parameter(s):\n");
          for (String str2 : localListenerMethod.parameters())
            localStringBuilder.append("\n  ").append(str2);
          localStringBuilder.append("\n\nThese may be listed in any order but will be searched for from top to bottom.");
          error(localExecutableElement, localStringBuilder.toString(), new Object[0]);
          return;
        }
      }
    }
    ListenerBinding localListenerBinding = new ListenerBinding(str1, Arrays.asList(arrayOfParameter), bool1);
    ViewInjector localViewInjector = getOrCreateTargetClass(paramMap, localTypeElement);
    int k = arrayOfInt.length;
    for (int m = 0; m < k; m++)
    {
      int n = arrayOfInt[m];
      if (!localViewInjector.addListener(n, localListenerClass, localListenerMethod, localListenerBinding))
      {
        Object[] arrayOfObject3 = new Object[3];
        arrayOfObject3[0] = paramClass.getSimpleName();
        arrayOfObject3[1] = Integer.valueOf(n);
        arrayOfObject3[2] = localTypeElement.getQualifiedName();
        error(paramElement, "Multiple @%s methods declared for ID %s in %s.", arrayOfObject3);
        return;
      }
    }
    paramSet.add(localTypeElement.toString());
  }

  public Set<String> getSupportedAnnotationTypes()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.add(InjectView.class.getCanonicalName());
    localLinkedHashSet.add(InjectViews.class.getCanonicalName());
    Iterator localIterator = LISTENERS.iterator();
    while (localIterator.hasNext())
      localLinkedHashSet.add(((Class)localIterator.next()).getCanonicalName());
    return localLinkedHashSet;
  }

  public SourceVersion getSupportedSourceVersion()
  {
    return SourceVersion.latestSupported();
  }

  public void init(ProcessingEnvironment paramProcessingEnvironment)
  {
    try
    {
      super.init(paramProcessingEnvironment);
      this.elementUtils = paramProcessingEnvironment.getElementUtils();
      this.typeUtils = paramProcessingEnvironment.getTypeUtils();
      this.filer = paramProcessingEnvironment.getFiler();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean process(Set<? extends TypeElement> paramSet, RoundEnvironment paramRoundEnvironment)
  {
    Iterator localIterator = findAndParseTargets(paramRoundEnvironment).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      TypeElement localTypeElement = (TypeElement)localEntry.getKey();
      ViewInjector localViewInjector = (ViewInjector)localEntry.getValue();
      try
      {
        Writer localWriter = this.filer.createSourceFile(localViewInjector.getFqcn(), new Element[] { localTypeElement }).openWriter();
        localWriter.write(localViewInjector.brewJava());
        localWriter.flush();
        localWriter.close();
      }
      catch (IOException localIOException)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localTypeElement;
        arrayOfObject[1] = localIOException.getMessage();
        error(localTypeElement, "Unable to write injector for type %s: %s", arrayOfObject);
      }
    }
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.internal.ButterKnifeProcessor
 * JD-Core Version:    0.6.2
 */