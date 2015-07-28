from django.conf.urls import patterns, include, url
from django.contrib import admin
from django.conf.urls.static import static
from django.contrib.staticfiles.urls import staticfiles_urlpatterns
from gpx_main.MainPage.Index_Page import Index_Page
from gpx_main.MainPage.Configure_Page import Configure_Page, Upload_Page


#  URL Patterns
urlpatterns = patterns('',
    url(r'^$', Index_Page),
    url(r'^admin/', include(admin.site.urls)),
    url(r'^configure/upload', Upload_Page),
    url(r'^configure/', Configure_Page),

)

#  Add Static Files
urlpatterns += staticfiles_urlpatterns()