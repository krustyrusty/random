#URLconf

#to call a view (in views.py), we need to map it to a URL
from django.conf.urls import patterns, url
import views


urlpatterns = patterns('',
    url(r'^$', views.HomepageView.as_view(), name='homepage'),
    url(r'^(?P<pk>\d+)/$', views.DetailView.as_view(), name='detail'),

    url(r'^accountitemlist', views.AccountItemsView.as_view(), name='account_items'),
    url(r'^(?P<pk>\d+)/$', views.DetailView.as_view(), name='account_detail'),


#    url(r'^detail', views.DetailView.as_view(), name='detail')
)

