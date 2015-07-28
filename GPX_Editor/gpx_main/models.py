from django.db import models


#-----------------------------#
#-     Route File Object     -#
#-----------------------------#
class RouteFile(models.Model):
    filename_text = models.FileField()
    valid_status = models.BooleanField(default=False)


#---------------------------#
#-     Waypoint Object     -#
#---------------------------#
class Waypoint(models.Model):
    index = models.IntegerField()
    latitude = models.DecimalField(max_digits=12,decimal_places=4)
    longitude= models.DecimalField(max_digits=12,decimal_places=4)
    elevation= models.DecimalField(max_digits=12,decimal_places=4)
