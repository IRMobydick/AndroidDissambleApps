package com.squareup.javawriter;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.Modifier;

public class JavaWriter
  implements Closeable
{
  private static final String INDENT = "  ";
  private static final int MAX_SINGLE_LINE_ATTRIBUTES = 3;
  private static final EnumSet<Scope> METHOD_SCOPES = EnumSet.of(Scope.NON_ABSTRACT_METHOD, Scope.CONSTRUCTOR, Scope.CONTROL_FLOW, Scope.INITIALIZER);
  private static final Pattern TYPE_PATTERN = Pattern.compile("(?:[\\w$]+\\.)*([\\w\\.*$]+)");
  private final Map<String, String> importedTypes = new LinkedHashMap();
  private String indent = "  ";
  private boolean isCompressingTypes = true;
  private final Writer out;
  private String packagePrefix;
  private final Deque<Scope> scopes = new ArrayDeque();
  private final Deque<String> types = new ArrayDeque();

  public JavaWriter(Writer paramWriter)
  {
    this.out = paramWriter;
  }

  private void checkInMethod()
  {
    if (!METHOD_SCOPES.contains(this.scopes.peekFirst()))
      throw new IllegalArgumentException();
  }

  private boolean containsArray(Collection<?> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      if ((localIterator.next() instanceof Object[]))
        return true;
    return false;
  }

  private JavaWriter emitAnnotationValue(Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof Object[]))
    {
      this.out.write("{");
      int i = 1;
      this.scopes.push(Scope.ANNOTATION_ARRAY_VALUE);
      Object[] arrayOfObject = (Object[])paramObject;
      int j = arrayOfObject.length;
      int k = 0;
      if (k < j)
      {
        Object localObject = arrayOfObject[k];
        if (i != 0)
        {
          i = 0;
          this.out.write("\n");
        }
        while (true)
        {
          indent();
          this.out.write(localObject.toString());
          k++;
          break;
          this.out.write(",\n");
        }
      }
      Scope[] arrayOfScope = new Scope[1];
      arrayOfScope[0] = Scope.ANNOTATION_ARRAY_VALUE;
      popScope(arrayOfScope);
      this.out.write("\n");
      indent();
      this.out.write("}");
      return this;
    }
    this.out.write(paramObject.toString());
    return this;
  }

  private JavaWriter emitCompressedType(String paramString)
    throws IOException
  {
    if (this.isCompressingTypes)
    {
      this.out.write(compressType(paramString));
      return this;
    }
    this.out.write(paramString);
    return this;
  }

  private JavaWriter emitLastEnumValue(String paramString)
    throws IOException
  {
    indent();
    this.out.write(paramString);
    this.out.write(";\n");
    return this;
  }

  private void emitModifiers(Set<Modifier> paramSet)
    throws IOException
  {
    if (paramSet.isEmpty());
    while (true)
    {
      return;
      if (!(paramSet instanceof EnumSet))
        paramSet = EnumSet.copyOf(paramSet);
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        Modifier localModifier = (Modifier)localIterator.next();
        this.out.append(localModifier.toString()).append(' ');
      }
    }
  }

  private void hangingIndent()
    throws IOException
  {
    int i = 0;
    int j = 2 + this.scopes.size();
    while (i < j)
    {
      this.out.write(this.indent);
      i++;
    }
  }

  private void indent()
    throws IOException
  {
    int i = 0;
    int j = this.scopes.size();
    while (i < j)
    {
      this.out.write(this.indent);
      i++;
    }
  }

  private boolean isAmbiguous(String paramString)
  {
    return this.importedTypes.values().contains(paramString);
  }

  private static boolean isClassInPackage(String paramString1, String paramString2)
  {
    if (paramString1.startsWith(paramString2))
    {
      if (paramString1.indexOf('.', paramString2.length()) == -1);
      while (Character.isUpperCase(paramString1.charAt(paramString2.length())))
        return true;
    }
    return false;
  }

  private void popScope(Scope[] paramArrayOfScope)
  {
    if (!EnumSet.copyOf(Arrays.asList(paramArrayOfScope)).contains(this.scopes.pop()))
      throw new IllegalStateException();
  }

  public static String rawType(String paramString)
  {
    int i = paramString.indexOf('<');
    if (i != -1)
      paramString = paramString.substring(0, i);
    return paramString;
  }

  public static String stringLiteral(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('"');
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default:
        if (Character.isISOControl(c))
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(c);
          localStringBuilder.append(String.format("\\u%04x", arrayOfObject));
        }
        break;
      case '"':
      case '\\':
      case '\b':
      case '\t':
      case '\n':
      case '\f':
      case '\r':
      }
      while (true)
      {
        i++;
        break;
        localStringBuilder.append("\\\"");
        continue;
        localStringBuilder.append("\\\\");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append(c);
      }
    }
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }

  public static String type(Class<?> paramClass, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length == 0)
      return paramClass.getCanonicalName();
    if (paramClass.getTypeParameters().length != paramArrayOfString.length)
      throw new IllegalArgumentException();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getCanonicalName());
    localStringBuilder.append("<");
    localStringBuilder.append(paramArrayOfString[0]);
    for (int i = 1; i < paramArrayOfString.length; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfString[i]);
    }
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }

  public JavaWriter beginConstructor(Set<Modifier> paramSet, List<String> paramList1, List<String> paramList2)
    throws IOException
  {
    beginMethod(null, rawType((String)this.types.peekFirst()), paramSet, paramList1, paramList2);
    return this;
  }

  public JavaWriter beginConstructor(Set<Modifier> paramSet, String[] paramArrayOfString)
    throws IOException
  {
    beginMethod(null, rawType((String)this.types.peekFirst()), paramSet, paramArrayOfString);
    return this;
  }

  public JavaWriter beginControlFlow(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    checkInMethod();
    indent();
    this.out.write(String.format(paramString, paramArrayOfObject));
    this.out.write(" {\n");
    this.scopes.push(Scope.CONTROL_FLOW);
    return this;
  }

  public JavaWriter beginInitializer(boolean paramBoolean)
    throws IOException
  {
    indent();
    if (paramBoolean)
    {
      this.out.write("static");
      this.out.write(" {\n");
    }
    while (true)
    {
      this.scopes.push(Scope.INITIALIZER);
      return this;
      this.out.write("{\n");
    }
  }

  public JavaWriter beginMethod(String paramString1, String paramString2, Set<Modifier> paramSet, List<String> paramList1, List<String> paramList2)
    throws IOException
  {
    indent();
    emitModifiers(paramSet);
    if (paramString1 != null)
    {
      emitCompressedType(paramString1);
      this.out.write(" ");
      this.out.write(paramString2);
    }
    while (true)
    {
      this.out.write("(");
      if (paramList1 == null)
        break;
      int j = 0;
      while (j < paramList1.size())
      {
        if (j != 0)
          this.out.write(", ");
        int k = j + 1;
        emitCompressedType((String)paramList1.get(j));
        this.out.write(" ");
        j = k + 1;
        emitCompressedType((String)paramList1.get(k));
      }
      emitCompressedType(paramString2);
    }
    this.out.write(")");
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      this.out.write("\n");
      indent();
      this.out.write("    throws ");
      for (int i = 0; i < paramList2.size(); i++)
      {
        if (i != 0)
          this.out.write(", ");
        emitCompressedType((String)paramList2.get(i));
      }
    }
    if ((paramSet.contains(Modifier.ABSTRACT)) || (Scope.INTERFACE_DECLARATION.equals(this.scopes.peek())))
    {
      this.out.write(";\n");
      this.scopes.push(Scope.ABSTRACT_METHOD);
      return this;
    }
    this.out.write(" {\n");
    Deque localDeque = this.scopes;
    if (paramString1 == null);
    for (Scope localScope = Scope.CONSTRUCTOR; ; localScope = Scope.NON_ABSTRACT_METHOD)
    {
      localDeque.push(localScope);
      return this;
    }
  }

  public JavaWriter beginMethod(String paramString1, String paramString2, Set<Modifier> paramSet, String[] paramArrayOfString)
    throws IOException
  {
    return beginMethod(paramString1, paramString2, paramSet, Arrays.asList(paramArrayOfString), null);
  }

  public JavaWriter beginType(String paramString1, String paramString2)
    throws IOException
  {
    return beginType(paramString1, paramString2, EnumSet.noneOf(Modifier.class), null, new String[0]);
  }

  public JavaWriter beginType(String paramString1, String paramString2, Set<Modifier> paramSet)
    throws IOException
  {
    return beginType(paramString1, paramString2, paramSet, null, new String[0]);
  }

  public JavaWriter beginType(String paramString1, String paramString2, Set<Modifier> paramSet, String paramString3, String[] paramArrayOfString)
    throws IOException
  {
    indent();
    emitModifiers(paramSet);
    this.out.write(paramString2);
    this.out.write(" ");
    emitCompressedType(paramString1);
    if (paramString3 != null)
    {
      this.out.write(" extends ");
      emitCompressedType(paramString3);
    }
    if (paramArrayOfString.length > 0)
    {
      this.out.write("\n");
      indent();
      this.out.write("    implements ");
      for (int i = 0; i < paramArrayOfString.length; i++)
      {
        if (i != 0)
          this.out.write(", ");
        emitCompressedType(paramArrayOfString[i]);
      }
    }
    this.out.write(" {\n");
    Deque localDeque = this.scopes;
    if ("interface".equals(paramString2));
    for (Scope localScope = Scope.INTERFACE_DECLARATION; ; localScope = Scope.TYPE_DECLARATION)
    {
      localDeque.push(localScope);
      this.types.push(paramString1);
      return this;
    }
  }

  public void close()
    throws IOException
  {
    this.out.close();
  }

  public String compressType(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.packagePrefix == null)
      throw new IllegalStateException();
    Matcher localMatcher = TYPE_PATTERN.matcher(paramString);
    int i = 0;
    boolean bool = localMatcher.find(i);
    if (bool);
    for (int j = localMatcher.start(); ; j = paramString.length())
    {
      localStringBuilder.append(paramString, i, j);
      if (bool)
        break;
      return localStringBuilder.toString();
    }
    String str1 = localMatcher.group(0);
    String str2 = (String)this.importedTypes.get(str1);
    if (str2 != null)
      localStringBuilder.append(str2);
    while (true)
    {
      i = localMatcher.end();
      break;
      if (isClassInPackage(str1, this.packagePrefix))
      {
        String str3 = str1.substring(this.packagePrefix.length());
        if (isAmbiguous(str3))
          localStringBuilder.append(str1);
        else
          localStringBuilder.append(str3);
      }
      else if (isClassInPackage(str1, "java.lang."))
      {
        localStringBuilder.append(str1.substring("java.lang.".length()));
      }
      else
      {
        localStringBuilder.append(str1);
      }
    }
  }

  public JavaWriter emitAnnotation(Class<? extends Annotation> paramClass)
    throws IOException
  {
    return emitAnnotation(type(paramClass, new String[0]), Collections.emptyMap());
  }

  public JavaWriter emitAnnotation(Class<? extends Annotation> paramClass, Object paramObject)
    throws IOException
  {
    return emitAnnotation(type(paramClass, new String[0]), paramObject);
  }

  public JavaWriter emitAnnotation(Class<? extends Annotation> paramClass, Map<String, ?> paramMap)
    throws IOException
  {
    return emitAnnotation(type(paramClass, new String[0]), paramMap);
  }

  public JavaWriter emitAnnotation(String paramString)
    throws IOException
  {
    return emitAnnotation(paramString, Collections.emptyMap());
  }

  public JavaWriter emitAnnotation(String paramString, Object paramObject)
    throws IOException
  {
    indent();
    this.out.write("@");
    emitCompressedType(paramString);
    this.out.write("(");
    emitAnnotationValue(paramObject);
    this.out.write(")");
    this.out.write("\n");
    return this;
  }

  public JavaWriter emitAnnotation(String paramString, Map<String, ?> paramMap)
    throws IOException
  {
    indent();
    this.out.write("@");
    emitCompressedType(paramString);
    int i;
    String str;
    label105: Iterator localIterator;
    switch (paramMap.size())
    {
    default:
      if ((paramMap.size() > 3) || (containsArray(paramMap.values())))
      {
        i = 1;
        this.out.write("(");
        this.scopes.push(Scope.ANNOTATION_ATTRIBUTE);
        if (i == 0)
          break label322;
        str = "\n";
        localIterator = paramMap.entrySet().iterator();
      }
      break;
    case 1:
      while (true)
        if (localIterator.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator.next();
          this.out.write(str);
          if (i != 0)
          {
            str = ",\n";
            label158: if (i != 0)
              indent();
            this.out.write((String)localEntry2.getKey());
            this.out.write(" = ");
            emitAnnotationValue(localEntry2.getValue());
            continue;
            Map.Entry localEntry1 = (Map.Entry)paramMap.entrySet().iterator().next();
            this.out.write("(");
            if (!"value".equals(localEntry1.getKey()))
            {
              this.out.write((String)localEntry1.getKey());
              this.out.write(" = ");
            }
            emitAnnotationValue(localEntry1.getValue());
            this.out.write(")");
          }
        }
    case 0:
    }
    while (true)
    {
      this.out.write("\n");
      return this;
      i = 0;
      break;
      label322: str = "";
      break label105;
      str = ", ";
      break label158;
      Scope[] arrayOfScope = new Scope[1];
      arrayOfScope[0] = Scope.ANNOTATION_ATTRIBUTE;
      popScope(arrayOfScope);
      if (i != 0)
      {
        this.out.write("\n");
        indent();
      }
      this.out.write(")");
    }
  }

  public JavaWriter emitEmptyLine()
    throws IOException
  {
    this.out.write("\n");
    return this;
  }

  public JavaWriter emitEnumValue(String paramString)
    throws IOException
  {
    indent();
    this.out.write(paramString);
    this.out.write(",\n");
    return this;
  }

  public JavaWriter emitEnumValue(String paramString, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
      return emitLastEnumValue(paramString);
    return emitEnumValue(paramString);
  }

  public JavaWriter emitEnumValues(Iterable<String> paramIterable)
    throws IOException
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localIterator.hasNext())
        emitEnumValue(str);
      else
        emitLastEnumValue(str);
    }
    return this;
  }

  public JavaWriter emitField(String paramString1, String paramString2)
    throws IOException
  {
    return emitField(paramString1, paramString2, EnumSet.noneOf(Modifier.class), null);
  }

  public JavaWriter emitField(String paramString1, String paramString2, Set<Modifier> paramSet)
    throws IOException
  {
    return emitField(paramString1, paramString2, paramSet, null);
  }

  public JavaWriter emitField(String paramString1, String paramString2, Set<Modifier> paramSet, String paramString3)
    throws IOException
  {
    indent();
    emitModifiers(paramSet);
    emitCompressedType(paramString1);
    this.out.write(" ");
    this.out.write(paramString2);
    if (paramString3 != null)
    {
      this.out.write(" =");
      if (!paramString3.startsWith("\n"))
        this.out.write(" ");
      String[] arrayOfString = paramString3.split("\n", -1);
      this.out.write(arrayOfString[0]);
      for (int i = 1; i < arrayOfString.length; i++)
      {
        this.out.write("\n");
        hangingIndent();
        this.out.write(arrayOfString[i]);
      }
    }
    this.out.write(";\n");
    return this;
  }

  public JavaWriter emitImports(Collection<String> paramCollection)
    throws IOException
  {
    Iterator localIterator = new TreeSet(paramCollection).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Matcher localMatcher = TYPE_PATTERN.matcher(str);
      if (!localMatcher.matches())
        throw new IllegalArgumentException(str);
      if (this.importedTypes.put(str, localMatcher.group(1)) != null)
        throw new IllegalArgumentException(str);
      this.out.write("import ");
      this.out.write(str);
      this.out.write(";\n");
    }
    return this;
  }

  public JavaWriter emitImports(Class<?>[] paramArrayOfClass)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfClass.length);
    int i = paramArrayOfClass.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(paramArrayOfClass[j].getName());
    return emitImports(localArrayList);
  }

  public JavaWriter emitImports(String[] paramArrayOfString)
    throws IOException
  {
    return emitImports(Arrays.asList(paramArrayOfString));
  }

  public JavaWriter emitJavadoc(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    String str1 = String.format(paramString, paramArrayOfObject);
    indent();
    this.out.write("/**\n");
    for (String str2 : str1.split("\n"))
    {
      indent();
      this.out.write(" *");
      if (!str2.isEmpty())
      {
        this.out.write(" ");
        this.out.write(str2);
      }
      this.out.write("\n");
    }
    indent();
    this.out.write(" */\n");
    return this;
  }

  public JavaWriter emitPackage(String paramString)
    throws IOException
  {
    if (this.packagePrefix != null)
      throw new IllegalStateException();
    if (paramString.isEmpty())
    {
      this.packagePrefix = "";
      return this;
    }
    this.out.write("package ");
    this.out.write(paramString);
    this.out.write(";\n\n");
    this.packagePrefix = (paramString + ".");
    return this;
  }

  public JavaWriter emitSingleLineComment(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    indent();
    this.out.write("// ");
    this.out.write(String.format(paramString, paramArrayOfObject));
    this.out.write("\n");
    return this;
  }

  public JavaWriter emitStatement(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    checkInMethod();
    String[] arrayOfString = String.format(paramString, paramArrayOfObject).split("\n", -1);
    indent();
    this.out.write(arrayOfString[0]);
    for (int i = 1; i < arrayOfString.length; i++)
    {
      this.out.write("\n");
      hangingIndent();
      this.out.write(arrayOfString[i]);
    }
    this.out.write(";\n");
    return this;
  }

  public JavaWriter emitStaticImports(Collection<String> paramCollection)
    throws IOException
  {
    Iterator localIterator = new TreeSet(paramCollection).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Matcher localMatcher = TYPE_PATTERN.matcher(str);
      if (!localMatcher.matches())
        throw new IllegalArgumentException(str);
      if (this.importedTypes.put(str, localMatcher.group(1)) != null)
        throw new IllegalArgumentException(str);
      this.out.write("import static ");
      this.out.write(str);
      this.out.write(";\n");
    }
    return this;
  }

  public JavaWriter emitStaticImports(String[] paramArrayOfString)
    throws IOException
  {
    return emitStaticImports(Arrays.asList(paramArrayOfString));
  }

  public JavaWriter endConstructor()
    throws IOException
  {
    Scope[] arrayOfScope = new Scope[1];
    arrayOfScope[0] = Scope.CONSTRUCTOR;
    popScope(arrayOfScope);
    indent();
    this.out.write("}\n");
    return this;
  }

  public JavaWriter endControlFlow()
    throws IOException
  {
    return endControlFlow(null, new Object[0]);
  }

  public JavaWriter endControlFlow(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    Scope[] arrayOfScope = new Scope[1];
    arrayOfScope[0] = Scope.CONTROL_FLOW;
    popScope(arrayOfScope);
    indent();
    if (paramString != null)
    {
      this.out.write("} ");
      this.out.write(String.format(paramString, paramArrayOfObject));
      this.out.write(";\n");
      return this;
    }
    this.out.write("}\n");
    return this;
  }

  public JavaWriter endInitializer()
    throws IOException
  {
    Scope[] arrayOfScope = new Scope[1];
    arrayOfScope[0] = Scope.INITIALIZER;
    popScope(arrayOfScope);
    indent();
    this.out.write("}\n");
    return this;
  }

  public JavaWriter endMethod()
    throws IOException
  {
    Scope localScope = (Scope)this.scopes.pop();
    if ((localScope == Scope.NON_ABSTRACT_METHOD) || (localScope == Scope.CONSTRUCTOR))
    {
      indent();
      this.out.write("}\n");
    }
    while (localScope == Scope.ABSTRACT_METHOD)
      return this;
    throw new IllegalStateException();
  }

  public JavaWriter endType()
    throws IOException
  {
    Scope[] arrayOfScope = new Scope[2];
    arrayOfScope[0] = Scope.TYPE_DECLARATION;
    arrayOfScope[1] = Scope.INTERFACE_DECLARATION;
    popScope(arrayOfScope);
    this.types.pop();
    indent();
    this.out.write("}\n");
    return this;
  }

  public String getIndent()
  {
    return this.indent;
  }

  public boolean isCompressingTypes()
  {
    return this.isCompressingTypes;
  }

  public JavaWriter nextControlFlow(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    Scope[] arrayOfScope = new Scope[1];
    arrayOfScope[0] = Scope.CONTROL_FLOW;
    popScope(arrayOfScope);
    indent();
    this.scopes.push(Scope.CONTROL_FLOW);
    this.out.write("} ");
    this.out.write(String.format(paramString, paramArrayOfObject));
    this.out.write(" {\n");
    return this;
  }

  public void setCompressingTypes(boolean paramBoolean)
  {
    this.isCompressingTypes = paramBoolean;
  }

  public void setIndent(String paramString)
  {
    this.indent = paramString;
  }

  private static enum Scope
  {
    static
    {
      INTERFACE_DECLARATION = new Scope("INTERFACE_DECLARATION", 1);
      ABSTRACT_METHOD = new Scope("ABSTRACT_METHOD", 2);
      NON_ABSTRACT_METHOD = new Scope("NON_ABSTRACT_METHOD", 3);
      CONSTRUCTOR = new Scope("CONSTRUCTOR", 4);
      CONTROL_FLOW = new Scope("CONTROL_FLOW", 5);
      ANNOTATION_ATTRIBUTE = new Scope("ANNOTATION_ATTRIBUTE", 6);
      ANNOTATION_ARRAY_VALUE = new Scope("ANNOTATION_ARRAY_VALUE", 7);
      INITIALIZER = new Scope("INITIALIZER", 8);
      Scope[] arrayOfScope = new Scope[9];
      arrayOfScope[0] = TYPE_DECLARATION;
      arrayOfScope[1] = INTERFACE_DECLARATION;
      arrayOfScope[2] = ABSTRACT_METHOD;
      arrayOfScope[3] = NON_ABSTRACT_METHOD;
      arrayOfScope[4] = CONSTRUCTOR;
      arrayOfScope[5] = CONTROL_FLOW;
      arrayOfScope[6] = ANNOTATION_ATTRIBUTE;
      arrayOfScope[7] = ANNOTATION_ARRAY_VALUE;
      arrayOfScope[8] = INITIALIZER;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.javawriter.JavaWriter
 * JD-Core Version:    0.6.2
 */