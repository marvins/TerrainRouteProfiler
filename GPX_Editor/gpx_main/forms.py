__author__ = 'Marvin Smith'

from django import forms

class RouteFileForm(forms.Form):
    file = forms.FileField()