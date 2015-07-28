__author__ = 'Marvin Smith'

from django.http import HttpResponse
from django.template.loader import get_template
from django.template import RequestContext
from ..models import RouteFile
from django.core.context_processors import csrf
from ..forms import RouteFileForm
from django.views.decorators.csrf import csrf_exempt, csrf_protect

#----------------------#
#-      Main Page     -#
#----------------------#
def Configure_Page(request):

    print('Request: ' + request.path + ', Method: ' + request.method)

    #  Build the Form
    form = RouteFileForm()

    route_data = RouteFile()

    context_info = {"Route_Pathname": route_data.filename_text,
                    "Route_Status":  route_data.valid_status }
    context_info.update(csrf(request))

    t = get_template('configure.html')
    html = t.render(RequestContext(request, context_info))
    return HttpResponse(html)


#------------------------#
#-      Upload Page     -#
#------------------------#
def Upload_Page(request):

    #  Create the context info
    context_info = {}
    print("Upload Page : " + request.method)

    #  Process the POST Request
    if request.method == 'POST':

        #  Create the context
        print('Files: ' + str(request.FILES))
        print('Raw Post Data: ' + str(request.POST).strip())
        print('Body: ' + str(request.body))
