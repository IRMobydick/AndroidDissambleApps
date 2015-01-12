package com.ubercab.client.feature.notification;

import com.squareup.picasso.Picasso;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class NotificationPainter$$InjectAdapter extends Binding<NotificationPainter>
  implements MembersInjector<NotificationPainter>
{
  private Binding<Picasso> mPicasso;

  public NotificationPainter$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.notification.NotificationPainter", false, NotificationPainter.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", NotificationPainter.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPicasso);
  }

  public void injectMembers(NotificationPainter paramNotificationPainter)
  {
    paramNotificationPainter.mPicasso = ((Picasso)this.mPicasso.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.NotificationPainter..InjectAdapter
 * JD-Core Version:    0.6.2
 */