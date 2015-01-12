package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.TokenQueue;

class QueryParser
{
  private static final String[] AttributeEvals = { "=", "!=", "^=", "$=", "*=", "~=" };
  private static final Pattern NTH_AB = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
  private static final Pattern NTH_B = Pattern.compile("(\\+|-)?(\\d+)");
  private static final String[] combinators = { ",", ">", "+", "~", " " };
  private List<Evaluator> evals = new ArrayList();
  private String query;
  private TokenQueue tq;

  private QueryParser(String paramString)
  {
    this.query = paramString;
    this.tq = new TokenQueue(paramString);
  }

  private void allElements()
  {
    this.evals.add(new Evaluator.AllElements());
  }

  private void byAttribute()
  {
    TokenQueue localTokenQueue = new TokenQueue(this.tq.chompBalanced('[', ']'));
    String str = localTokenQueue.consumeToAny(AttributeEvals);
    Validate.notEmpty(str);
    localTokenQueue.consumeWhitespace();
    if (localTokenQueue.isEmpty())
    {
      if (str.startsWith("^"))
      {
        this.evals.add(new Evaluator.AttributeStarting(str.substring(1)));
        return;
      }
      this.evals.add(new Evaluator.Attribute(str));
      return;
    }
    if (localTokenQueue.matchChomp("="))
    {
      this.evals.add(new Evaluator.AttributeWithValue(str, localTokenQueue.remainder()));
      return;
    }
    if (localTokenQueue.matchChomp("!="))
    {
      this.evals.add(new Evaluator.AttributeWithValueNot(str, localTokenQueue.remainder()));
      return;
    }
    if (localTokenQueue.matchChomp("^="))
    {
      this.evals.add(new Evaluator.AttributeWithValueStarting(str, localTokenQueue.remainder()));
      return;
    }
    if (localTokenQueue.matchChomp("$="))
    {
      this.evals.add(new Evaluator.AttributeWithValueEnding(str, localTokenQueue.remainder()));
      return;
    }
    if (localTokenQueue.matchChomp("*="))
    {
      this.evals.add(new Evaluator.AttributeWithValueContaining(str, localTokenQueue.remainder()));
      return;
    }
    if (localTokenQueue.matchChomp("~="))
    {
      this.evals.add(new Evaluator.AttributeWithValueMatching(str, Pattern.compile(localTokenQueue.remainder())));
      return;
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.query;
    arrayOfObject[1] = localTokenQueue.remainder();
    throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", arrayOfObject);
  }

  private void byClass()
  {
    String str = this.tq.consumeCssIdentifier();
    Validate.notEmpty(str);
    this.evals.add(new Evaluator.Class(str.trim().toLowerCase()));
  }

  private void byId()
  {
    String str = this.tq.consumeCssIdentifier();
    Validate.notEmpty(str);
    this.evals.add(new Evaluator.Id(str));
  }

  private void byTag()
  {
    String str = this.tq.consumeElementSelector();
    Validate.notEmpty(str);
    if (str.contains("|"))
      str = str.replace("|", ":");
    this.evals.add(new Evaluator.Tag(str.trim().toLowerCase()));
  }

  private void combinator(char paramChar)
  {
    this.tq.consumeWhitespace();
    Evaluator localEvaluator = parse(consumeSubQuery());
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (this.evals.size() == 1)
    {
      localObject1 = (Evaluator)this.evals.get(0);
      localObject2 = localObject1;
      boolean bool = localObject2 instanceof CombiningEvaluator.Or;
      i = 0;
      if (bool)
      {
        i = 0;
        if (paramChar != ',')
        {
          localObject1 = ((CombiningEvaluator.Or)localObject1).rightMostEvaluator();
          i = 1;
        }
      }
      this.evals.clear();
      if (paramChar != '>')
        break label186;
      Evaluator[] arrayOfEvaluator4 = new Evaluator[2];
      arrayOfEvaluator4[0] = localEvaluator;
      arrayOfEvaluator4[1] = new StructuralEvaluator.ImmediateParent((Evaluator)localObject1);
      localObject3 = new CombiningEvaluator.And(arrayOfEvaluator4);
      label135: if (i == 0)
        break label409;
      ((CombiningEvaluator.Or)localObject2).replaceRightMostEvaluator((Evaluator)localObject3);
    }
    while (true)
    {
      this.evals.add(localObject2);
      return;
      localObject1 = new CombiningEvaluator.And(this.evals);
      localObject2 = localObject1;
      i = 0;
      break;
      label186: if (paramChar == ' ')
      {
        Evaluator[] arrayOfEvaluator3 = new Evaluator[2];
        arrayOfEvaluator3[0] = localEvaluator;
        arrayOfEvaluator3[1] = new StructuralEvaluator.Parent((Evaluator)localObject1);
        localObject3 = new CombiningEvaluator.And(arrayOfEvaluator3);
        break label135;
      }
      if (paramChar == '+')
      {
        Evaluator[] arrayOfEvaluator2 = new Evaluator[2];
        arrayOfEvaluator2[0] = localEvaluator;
        arrayOfEvaluator2[1] = new StructuralEvaluator.ImmediatePreviousSibling((Evaluator)localObject1);
        localObject3 = new CombiningEvaluator.And(arrayOfEvaluator2);
        break label135;
      }
      if (paramChar == '~')
      {
        Evaluator[] arrayOfEvaluator1 = new Evaluator[2];
        arrayOfEvaluator1[0] = localEvaluator;
        arrayOfEvaluator1[1] = new StructuralEvaluator.PreviousSibling((Evaluator)localObject1);
        localObject3 = new CombiningEvaluator.And(arrayOfEvaluator1);
        break label135;
      }
      if (paramChar == ',')
      {
        CombiningEvaluator.Or localOr;
        if ((localObject1 instanceof CombiningEvaluator.Or))
        {
          localOr = (CombiningEvaluator.Or)localObject1;
          localOr.add(localEvaluator);
        }
        while (true)
        {
          localObject3 = localOr;
          break;
          localOr = new CombiningEvaluator.Or();
          localOr.add((Evaluator)localObject1);
          localOr.add(localEvaluator);
        }
      }
      throw new Selector.SelectorParseException("Unknown combinator: " + paramChar, new Object[0]);
      label409: localObject2 = localObject3;
    }
  }

  private int consumeIndex()
  {
    String str = this.tq.chompTo(")").trim();
    Validate.isTrue(StringUtil.isNumeric(str), "Index must be numeric");
    return Integer.parseInt(str);
  }

  private String consumeSubQuery()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
      if (!this.tq.isEmpty())
      {
        if (this.tq.matches("("))
          localStringBuilder.append("(").append(this.tq.chompBalanced('(', ')')).append(")");
        else if (this.tq.matches("["))
          localStringBuilder.append("[").append(this.tq.chompBalanced('[', ']')).append("]");
        else if (!this.tq.matchesAny(combinators));
      }
      else
      {
        return localStringBuilder.toString();
        localStringBuilder.append(this.tq.consume());
      }
  }

  private void contains(boolean paramBoolean)
  {
    TokenQueue localTokenQueue = this.tq;
    if (paramBoolean);
    String str2;
    for (String str1 = ":containsOwn"; ; str1 = ":contains")
    {
      localTokenQueue.consume(str1);
      str2 = TokenQueue.unescape(this.tq.chompBalanced('(', ')'));
      Validate.notEmpty(str2, ":contains(text) query must not be empty");
      if (!paramBoolean)
        break;
      this.evals.add(new Evaluator.ContainsOwnText(str2));
      return;
    }
    this.evals.add(new Evaluator.ContainsText(str2));
  }

  private void cssNthChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    String str1 = this.tq.chompTo(")").trim().toLowerCase();
    Matcher localMatcher1 = NTH_AB.matcher(str1);
    Matcher localMatcher2 = NTH_B.matcher(str1);
    int j;
    if ("odd".equals(str1))
    {
      i = 2;
      j = 1;
    }
    while (paramBoolean2)
      if (paramBoolean1)
      {
        this.evals.add(new Evaluator.IsNthLastOfType(i, j));
        return;
        if ("even".equals(str1))
        {
          i = 2;
          j = 0;
        }
        else if (localMatcher1.matches())
        {
          if (localMatcher1.group(3) != null)
            i = Integer.parseInt(localMatcher1.group(i).replaceFirst("^\\+", ""));
          String str2 = localMatcher1.group(4);
          j = 0;
          if (str2 != null)
            j = Integer.parseInt(localMatcher1.group(4).replaceFirst("^\\+", ""));
        }
        else if (localMatcher2.matches())
        {
          j = Integer.parseInt(localMatcher2.group().replaceFirst("^\\+", ""));
          i = 0;
        }
        else
        {
          Object[] arrayOfObject = new Object[i];
          arrayOfObject[0] = str1;
          throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", arrayOfObject);
        }
      }
      else
      {
        this.evals.add(new Evaluator.IsNthOfType(i, j));
        return;
      }
    if (paramBoolean1)
    {
      this.evals.add(new Evaluator.IsNthLastChild(i, j));
      return;
    }
    this.evals.add(new Evaluator.IsNthChild(i, j));
  }

  private void findElements()
  {
    if (this.tq.matchChomp("#"))
    {
      byId();
      return;
    }
    if (this.tq.matchChomp("."))
    {
      byClass();
      return;
    }
    if (this.tq.matchesWord())
    {
      byTag();
      return;
    }
    if (this.tq.matches("["))
    {
      byAttribute();
      return;
    }
    if (this.tq.matchChomp("*"))
    {
      allElements();
      return;
    }
    if (this.tq.matchChomp(":lt("))
    {
      indexLessThan();
      return;
    }
    if (this.tq.matchChomp(":gt("))
    {
      indexGreaterThan();
      return;
    }
    if (this.tq.matchChomp(":eq("))
    {
      indexEquals();
      return;
    }
    if (this.tq.matches(":has("))
    {
      has();
      return;
    }
    if (this.tq.matches(":contains("))
    {
      contains(false);
      return;
    }
    if (this.tq.matches(":containsOwn("))
    {
      contains(true);
      return;
    }
    if (this.tq.matches(":matches("))
    {
      matches(false);
      return;
    }
    if (this.tq.matches(":matchesOwn("))
    {
      matches(true);
      return;
    }
    if (this.tq.matches(":not("))
    {
      not();
      return;
    }
    if (this.tq.matchChomp(":nth-child("))
    {
      cssNthChild(false, false);
      return;
    }
    if (this.tq.matchChomp(":nth-last-child("))
    {
      cssNthChild(true, false);
      return;
    }
    if (this.tq.matchChomp(":nth-of-type("))
    {
      cssNthChild(false, true);
      return;
    }
    if (this.tq.matchChomp(":nth-last-of-type("))
    {
      cssNthChild(true, true);
      return;
    }
    if (this.tq.matchChomp(":first-child"))
    {
      this.evals.add(new Evaluator.IsFirstChild());
      return;
    }
    if (this.tq.matchChomp(":last-child"))
    {
      this.evals.add(new Evaluator.IsLastChild());
      return;
    }
    if (this.tq.matchChomp(":first-of-type"))
    {
      this.evals.add(new Evaluator.IsFirstOfType());
      return;
    }
    if (this.tq.matchChomp(":last-of-type"))
    {
      this.evals.add(new Evaluator.IsLastOfType());
      return;
    }
    if (this.tq.matchChomp(":only-child"))
    {
      this.evals.add(new Evaluator.IsOnlyChild());
      return;
    }
    if (this.tq.matchChomp(":only-of-type"))
    {
      this.evals.add(new Evaluator.IsOnlyOfType());
      return;
    }
    if (this.tq.matchChomp(":empty"))
    {
      this.evals.add(new Evaluator.IsEmpty());
      return;
    }
    if (this.tq.matchChomp(":root"))
    {
      this.evals.add(new Evaluator.IsRoot());
      return;
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.query;
    arrayOfObject[1] = this.tq.remainder();
    throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", arrayOfObject);
  }

  private void has()
  {
    this.tq.consume(":has");
    String str = this.tq.chompBalanced('(', ')');
    Validate.notEmpty(str, ":has(el) subselect must not be empty");
    this.evals.add(new StructuralEvaluator.Has(parse(str)));
  }

  private void indexEquals()
  {
    this.evals.add(new Evaluator.IndexEquals(consumeIndex()));
  }

  private void indexGreaterThan()
  {
    this.evals.add(new Evaluator.IndexGreaterThan(consumeIndex()));
  }

  private void indexLessThan()
  {
    this.evals.add(new Evaluator.IndexLessThan(consumeIndex()));
  }

  private void matches(boolean paramBoolean)
  {
    TokenQueue localTokenQueue = this.tq;
    if (paramBoolean);
    String str2;
    for (String str1 = ":matchesOwn"; ; str1 = ":matches")
    {
      localTokenQueue.consume(str1);
      str2 = this.tq.chompBalanced('(', ')');
      Validate.notEmpty(str2, ":matches(regex) query must not be empty");
      if (!paramBoolean)
        break;
      this.evals.add(new Evaluator.MatchesOwn(Pattern.compile(str2)));
      return;
    }
    this.evals.add(new Evaluator.Matches(Pattern.compile(str2)));
  }

  private void not()
  {
    this.tq.consume(":not");
    String str = this.tq.chompBalanced('(', ')');
    Validate.notEmpty(str, ":not(selector) subselect must not be empty");
    this.evals.add(new StructuralEvaluator.Not(parse(str)));
  }

  public static Evaluator parse(String paramString)
  {
    return new QueryParser(paramString).parse();
  }

  Evaluator parse()
  {
    this.tq.consumeWhitespace();
    if (this.tq.matchesAny(combinators))
    {
      this.evals.add(new StructuralEvaluator.Root());
      combinator(this.tq.consume());
    }
    while (!this.tq.isEmpty())
    {
      boolean bool = this.tq.consumeWhitespace();
      if (this.tq.matchesAny(combinators))
      {
        combinator(this.tq.consume());
        continue;
        findElements();
      }
      else if (bool)
      {
        combinator(' ');
      }
      else
      {
        findElements();
      }
    }
    if (this.evals.size() == 1)
      return (Evaluator)this.evals.get(0);
    return new CombiningEvaluator.And(this.evals);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.select.QueryParser
 * JD-Core Version:    0.6.2
 */