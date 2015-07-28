__author__ = 'Marvin Smith'

from django.http import HttpResponse
from django.template.loader import get_template
from django.template import RequestContext


#----------------------#
#-      Main Page     -#
#----------------------#
def Index_Page(request):

    t = get_template('index.html')
    html = t.render(RequestContext(request))
    return HttpResponse(html)

