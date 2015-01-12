package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class Bus
{
  public static final String DEFAULT_IDENTIFIER = "default";
  private final ThreadEnforcer enforcer;
  private final ThreadLocal<ConcurrentLinkedQueue<EventWithHandler>> eventsToDispatch = new ThreadLocal()
  {
    protected ConcurrentLinkedQueue<Bus.EventWithHandler> initialValue()
    {
      return new ConcurrentLinkedQueue();
    }
  };
  private final Map<Class<?>, Set<Class<?>>> flattenHierarchyCache = new HashMap();
  private final HandlerFinder handlerFinder;
  private final ConcurrentMap<Class<?>, Set<EventHandler>> handlersByType = new ConcurrentHashMap();
  private final String identifier;
  private final ThreadLocal<Boolean> isDispatching = new ThreadLocal()
  {
    protected Boolean initialValue()
    {
      return Boolean.valueOf(false);
    }
  };
  private final ConcurrentMap<Class<?>, EventProducer> producersByType = new ConcurrentHashMap();

  public Bus()
  {
    this("default");
  }

  public Bus(ThreadEnforcer paramThreadEnforcer)
  {
    this(paramThreadEnforcer, "default");
  }

  public Bus(ThreadEnforcer paramThreadEnforcer, String paramString)
  {
    this(paramThreadEnforcer, paramString, HandlerFinder.ANNOTATED);
  }

  Bus(ThreadEnforcer paramThreadEnforcer, String paramString, HandlerFinder paramHandlerFinder)
  {
    this.enforcer = paramThreadEnforcer;
    this.identifier = paramString;
    this.handlerFinder = paramHandlerFinder;
  }

  public Bus(String paramString)
  {
    this(ThreadEnforcer.MAIN, paramString);
  }

  private void dispatchProducerResultToHandler(EventHandler paramEventHandler, EventProducer paramEventProducer)
  {
    try
    {
      Object localObject2 = paramEventProducer.produceEvent();
      localObject1 = localObject2;
      if (localObject1 == null)
        return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Object localObject1;
      while (true)
      {
        throwRuntimeException("Producer " + paramEventProducer + " threw an exception.", localInvocationTargetException);
        localObject1 = null;
      }
      dispatch(localObject1, paramEventHandler);
    }
  }

  private Set<Class<?>> getClassesFor(Class<?> paramClass)
  {
    LinkedList localLinkedList = new LinkedList();
    HashSet localHashSet = new HashSet();
    localLinkedList.add(paramClass);
    while (!localLinkedList.isEmpty())
    {
      Class localClass1 = (Class)localLinkedList.remove(0);
      localHashSet.add(localClass1);
      Class localClass2 = localClass1.getSuperclass();
      if (localClass2 != null)
        localLinkedList.add(localClass2);
    }
    return localHashSet;
  }

  private static void throwRuntimeException(String paramString, InvocationTargetException paramInvocationTargetException)
  {
    Throwable localThrowable = paramInvocationTargetException.getCause();
    if (localThrowable != null)
      throw new RuntimeException(paramString + ": " + localThrowable.getMessage(), localThrowable);
    throw new RuntimeException(paramString + ": " + paramInvocationTargetException.getMessage(), paramInvocationTargetException);
  }

  protected void dispatch(Object paramObject, EventHandler paramEventHandler)
  {
    try
    {
      paramEventHandler.handleEvent(paramObject);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throwRuntimeException("Could not dispatch event: " + paramObject.getClass() + " to handler " + paramEventHandler, localInvocationTargetException);
    }
  }

  protected void dispatchQueuedEvents()
  {
    if (((Boolean)this.isDispatching.get()).booleanValue())
      return;
    this.isDispatching.set(Boolean.valueOf(true));
    try
    {
      while (true)
      {
        EventWithHandler localEventWithHandler = (EventWithHandler)((ConcurrentLinkedQueue)this.eventsToDispatch.get()).poll();
        if (localEventWithHandler == null)
          return;
        if (localEventWithHandler.handler.isValid())
          dispatch(localEventWithHandler.event, localEventWithHandler.handler);
      }
    }
    finally
    {
      this.isDispatching.set(Boolean.valueOf(false));
    }
  }

  protected void enqueueEvent(Object paramObject, EventHandler paramEventHandler)
  {
    ((ConcurrentLinkedQueue)this.eventsToDispatch.get()).offer(new EventWithHandler(paramObject, paramEventHandler));
  }

  Set<Class<?>> flattenHierarchy(Class<?> paramClass)
  {
    Set localSet = (Set)this.flattenHierarchyCache.get(paramClass);
    if (localSet == null)
    {
      localSet = getClassesFor(paramClass);
      this.flattenHierarchyCache.put(paramClass, localSet);
    }
    return localSet;
  }

  Set<EventHandler> getHandlersForEventType(Class<?> paramClass)
  {
    return (Set)this.handlersByType.get(paramClass);
  }

  EventProducer getProducerForEventType(Class<?> paramClass)
  {
    return (EventProducer)this.producersByType.get(paramClass);
  }

  public void post(Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException("Event to post must not be null.");
    this.enforcer.enforce(this);
    Set localSet1 = flattenHierarchy(paramObject.getClass());
    int i = 0;
    Iterator localIterator1 = localSet1.iterator();
    while (localIterator1.hasNext())
    {
      Set localSet2 = getHandlersForEventType((Class)localIterator1.next());
      if ((localSet2 != null) && (!localSet2.isEmpty()))
      {
        i = 1;
        Iterator localIterator2 = localSet2.iterator();
        while (localIterator2.hasNext())
          enqueueEvent(paramObject, (EventHandler)localIterator2.next());
      }
    }
    if ((i == 0) && (!(paramObject instanceof DeadEvent)))
      post(new DeadEvent(this, paramObject));
    dispatchQueuedEvents();
  }

  public void register(Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException("Object to register must not be null.");
    this.enforcer.enforce(this);
    Map localMap1 = this.handlerFinder.findAllProducers(paramObject);
    Iterator localIterator1 = localMap1.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Class localClass3 = (Class)localIterator1.next();
      EventProducer localEventProducer2 = (EventProducer)localMap1.get(localClass3);
      EventProducer localEventProducer3 = (EventProducer)this.producersByType.putIfAbsent(localClass3, localEventProducer2);
      if (localEventProducer3 != null)
        throw new IllegalArgumentException("Producer method for type " + localClass3 + " found on type " + localEventProducer2.target.getClass() + ", but already registered by type " + localEventProducer3.target.getClass() + ".");
      Set localSet = (Set)this.handlersByType.get(localClass3);
      if ((localSet != null) && (!localSet.isEmpty()))
      {
        Iterator localIterator5 = localSet.iterator();
        while (localIterator5.hasNext())
          dispatchProducerResultToHandler((EventHandler)localIterator5.next(), localEventProducer2);
      }
    }
    Map localMap2 = this.handlerFinder.findAllSubscribers(paramObject);
    Iterator localIterator2 = localMap2.keySet().iterator();
    while (localIterator2.hasNext())
    {
      Class localClass2 = (Class)localIterator2.next();
      Object localObject = (Set)this.handlersByType.get(localClass2);
      if (localObject == null)
      {
        CopyOnWriteArraySet localCopyOnWriteArraySet = new CopyOnWriteArraySet();
        localObject = (Set)this.handlersByType.putIfAbsent(localClass2, localCopyOnWriteArraySet);
        if (localObject == null)
          localObject = localCopyOnWriteArraySet;
      }
      ((Set)localObject).addAll((Set)localMap2.get(localClass2));
    }
    Iterator localIterator3 = localMap2.entrySet().iterator();
    label511: 
    while (localIterator3.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator3.next();
      Class localClass1 = (Class)localEntry.getKey();
      EventProducer localEventProducer1 = (EventProducer)this.producersByType.get(localClass1);
      if ((localEventProducer1 != null) && (localEventProducer1.isValid()))
      {
        Iterator localIterator4 = ((Set)localEntry.getValue()).iterator();
        while (true)
        {
          if (!localIterator4.hasNext())
            break label511;
          EventHandler localEventHandler = (EventHandler)localIterator4.next();
          if (!localEventProducer1.isValid())
            break;
          if (localEventHandler.isValid())
            dispatchProducerResultToHandler(localEventHandler, localEventProducer1);
        }
      }
    }
  }

  public String toString()
  {
    return "[Bus \"" + this.identifier + "\"]";
  }

  public void unregister(Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException("Object to unregister must not be null.");
    this.enforcer.enforce(this);
    Iterator localIterator1 = this.handlerFinder.findAllProducers(paramObject).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      Class localClass = (Class)localEntry2.getKey();
      EventProducer localEventProducer1 = getProducerForEventType(localClass);
      EventProducer localEventProducer2 = (EventProducer)localEntry2.getValue();
      if ((localEventProducer2 == null) || (!localEventProducer2.equals(localEventProducer1)))
        throw new IllegalArgumentException("Missing event producer for an annotated method. Is " + paramObject.getClass() + " registered?");
      ((EventProducer)this.producersByType.remove(localClass)).invalidate();
    }
    Iterator localIterator2 = this.handlerFinder.findAllSubscribers(paramObject).entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      Set localSet = getHandlersForEventType((Class)localEntry1.getKey());
      Collection localCollection = (Collection)localEntry1.getValue();
      if ((localSet == null) || (!localSet.containsAll(localCollection)))
        throw new IllegalArgumentException("Missing event handler for an annotated method. Is " + paramObject.getClass() + " registered?");
      Iterator localIterator3 = localSet.iterator();
      while (localIterator3.hasNext())
      {
        EventHandler localEventHandler = (EventHandler)localIterator3.next();
        if (localCollection.contains(localEventHandler))
          localEventHandler.invalidate();
      }
      localSet.removeAll(localCollection);
    }
  }

  static class EventWithHandler
  {
    final Object event;
    final EventHandler handler;

    public EventWithHandler(Object paramObject, EventHandler paramEventHandler)
    {
      this.event = paramObject;
      this.handler = paramEventHandler;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.otto.Bus
 * JD-Core Version:    0.6.2
 */