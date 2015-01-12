package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class FragmentTransitionCompat21
{
  public static void addTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    Transition localTransition = (Transition)paramObject;
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
      localTransition.addTarget((View)paramArrayList.get(j));
  }

  public static void addTransitionTargets(Object paramObject1, Object paramObject2, View paramView1, final ViewRetriever paramViewRetriever, View paramView2, EpicenterView paramEpicenterView, final Map<String, String> paramMap, final ArrayList<View> paramArrayList1, final Map<String, View> paramMap1, ArrayList<View> paramArrayList2)
  {
    if ((paramObject1 != null) || (paramObject2 != null))
    {
      final Transition localTransition = (Transition)paramObject1;
      if (localTransition != null)
        localTransition.addTarget(paramView2);
      if (paramObject2 != null)
        addTargets((Transition)paramObject2, paramArrayList2);
      if (paramViewRetriever != null)
        paramView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public boolean onPreDraw()
          {
            this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
            View localView1 = paramViewRetriever.getView();
            if (localView1 != null)
            {
              if (!paramMap.isEmpty())
              {
                FragmentTransitionCompat21.findNamedViews(paramMap1, localView1);
                paramMap1.keySet().retainAll(paramMap.values());
                Iterator localIterator = paramMap.entrySet().iterator();
                while (localIterator.hasNext())
                {
                  Map.Entry localEntry = (Map.Entry)localIterator.next();
                  String str = (String)localEntry.getValue();
                  View localView2 = (View)paramMap1.get(str);
                  if (localView2 != null)
                    localView2.setTransitionName((String)localEntry.getKey());
                }
              }
              if (localTransition != null)
              {
                FragmentTransitionCompat21.captureTransitioningViews(paramArrayList1, localView1);
                paramArrayList1.removeAll(paramMap1.values());
                FragmentTransitionCompat21.addTargets(localTransition, paramArrayList1);
              }
            }
            return true;
          }
        });
      setSharedElementEpicenter(localTransition, paramEpicenterView);
    }
  }

  public static void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }

  public static Object captureExitingViews(Object paramObject, View paramView, ArrayList<View> paramArrayList, Map<String, View> paramMap)
  {
    if (paramObject != null)
    {
      captureTransitioningViews(paramArrayList, paramView);
      if (paramMap != null)
        paramArrayList.removeAll(paramMap.values());
      if (paramArrayList.isEmpty())
        paramObject = null;
    }
    else
    {
      return paramObject;
    }
    addTargets((Transition)paramObject, paramArrayList);
    return paramObject;
  }

  private static void captureTransitioningViews(ArrayList<View> paramArrayList, View paramView)
  {
    ViewGroup localViewGroup;
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup))
        break label65;
      localViewGroup = (ViewGroup)paramView;
      if (!localViewGroup.isTransitionGroup())
        break label33;
      paramArrayList.add(localViewGroup);
    }
    while (true)
    {
      return;
      label33: int i = localViewGroup.getChildCount();
      for (int j = 0; j < i; j++)
        captureTransitioningViews(paramArrayList, localViewGroup.getChildAt(j));
    }
    label65: paramArrayList.add(paramView);
  }

  public static void cleanupTransitions(View paramView1, final View paramView2, Object paramObject1, final ArrayList<View> paramArrayList1, Object paramObject2, final ArrayList<View> paramArrayList2, Object paramObject3, final ArrayList<View> paramArrayList3, Object paramObject4, final ArrayList<View> paramArrayList4, final Map<String, View> paramMap)
  {
    final Transition localTransition1 = (Transition)paramObject1;
    final Transition localTransition2 = (Transition)paramObject2;
    final Transition localTransition3 = (Transition)paramObject3;
    final Transition localTransition4 = (Transition)paramObject4;
    if (localTransition4 != null)
      paramView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
          if (localTransition1 != null)
          {
            localTransition1.removeTarget(paramView2);
            FragmentTransitionCompat21.removeTargets(localTransition1, paramArrayList1);
          }
          if (localTransition2 != null)
            FragmentTransitionCompat21.removeTargets(localTransition2, paramArrayList2);
          if (localTransition3 != null)
            FragmentTransitionCompat21.removeTargets(localTransition3, paramArrayList3);
          Iterator localIterator = paramMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            ((View)localEntry.getValue()).setTransitionName((String)localEntry.getKey());
          }
          int i = paramArrayList4.size();
          for (int j = 0; j < i; j++)
            localTransition4.excludeTarget((View)paramArrayList4.get(j), false);
          localTransition4.excludeTarget(paramView2, false);
          return true;
        }
      });
  }

  public static Object cloneTransition(Object paramObject)
  {
    if (paramObject != null)
      paramObject = ((Transition)paramObject).clone();
    return paramObject;
  }

  public static void excludeTarget(Object paramObject, View paramView, boolean paramBoolean)
  {
    ((Transition)paramObject).excludeTarget(paramView, paramBoolean);
  }

  public static void findNamedViews(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = paramView.getTransitionName();
      if (str != null)
        paramMap.put(str, paramView);
      if ((paramView instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int i = localViewGroup.getChildCount();
        for (int j = 0; j < i; j++)
          findNamedViews(paramMap, localViewGroup.getChildAt(j));
      }
    }
  }

  private static Rect getBoundsOnScreen(View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    return localRect;
  }

  public static String getTransitionName(View paramView)
  {
    return paramView.getTransitionName();
  }

  public static Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3, boolean paramBoolean)
  {
    boolean bool = true;
    Transition localTransition1 = (Transition)paramObject1;
    Transition localTransition2 = (Transition)paramObject2;
    Transition localTransition3 = (Transition)paramObject3;
    if ((localTransition1 != null) && (localTransition2 != null))
      bool = paramBoolean;
    if (bool)
    {
      TransitionSet localTransitionSet1 = new TransitionSet();
      if (localTransition1 != null)
        localTransitionSet1.addTransition(localTransition1);
      if (localTransition2 != null)
        localTransitionSet1.addTransition(localTransition2);
      if (localTransition3 != null)
        localTransitionSet1.addTransition(localTransition3);
      return localTransitionSet1;
    }
    Object localObject;
    if ((localTransition2 != null) && (localTransition1 != null))
      localObject = new TransitionSet().addTransition(localTransition2).addTransition(localTransition1).setOrdering(1);
    while (localTransition3 != null)
    {
      TransitionSet localTransitionSet2 = new TransitionSet();
      if (localObject != null)
        localTransitionSet2.addTransition((Transition)localObject);
      localTransitionSet2.addTransition(localTransition3);
      return localTransitionSet2;
      if (localTransition2 != null)
      {
        localObject = localTransition2;
      }
      else
      {
        localObject = null;
        if (localTransition1 != null)
          localObject = localTransition1;
      }
    }
    return localObject;
  }

  public static void removeTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    Transition localTransition = (Transition)paramObject;
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
      localTransition.removeTarget((View)paramArrayList.get(j));
  }

  public static void setEpicenter(Object paramObject, View paramView)
  {
    ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
    {
      public Rect onGetEpicenter(Transition paramAnonymousTransition)
      {
        return this.val$epicenter;
      }
    });
  }

  private static void setSharedElementEpicenter(Transition paramTransition, EpicenterView paramEpicenterView)
  {
    if (paramTransition != null)
      paramTransition.setEpicenterCallback(new Transition.EpicenterCallback()
      {
        private Rect mEpicenter;

        public Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          if ((this.mEpicenter == null) && (this.val$epicenterView.epicenter != null))
            this.mEpicenter = FragmentTransitionCompat21.getBoundsOnScreen(this.val$epicenterView.epicenter);
          return this.mEpicenter;
        }
      });
  }

  public static class EpicenterView
  {
    public View epicenter;
  }

  public static abstract interface ViewRetriever
  {
    public abstract View getView();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionCompat21
 * JD-Core Version:    0.6.2
 */