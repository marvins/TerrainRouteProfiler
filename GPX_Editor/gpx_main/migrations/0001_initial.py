# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='RouteFile',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('filename_text', models.FileField(upload_to=b'')),
                ('valid_status', models.BooleanField(default=False)),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='Waypoint',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('index', models.IntegerField()),
                ('latitude', models.DecimalField(max_digits=12, decimal_places=4)),
                ('longitude', models.DecimalField(max_digits=12, decimal_places=4)),
                ('elevation', models.DecimalField(max_digits=12, decimal_places=4)),
            ],
            options={
            },
            bases=(models.Model,),
        ),
    ]
