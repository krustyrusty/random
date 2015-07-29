# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations
import datetime


class Migration(migrations.Migration):

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='AccountID',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('date_created', models.DateTimeField(default=datetime.date(2014, 11, 29))),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='AccountName',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('first_name', models.CharField(default=b' ', max_length=50, null=True)),
                ('last_name', models.CharField(default=b' ', max_length=50, null=True)),
                ('email', models.CharField(default=b' ', max_length=75, null=True)),
                ('phone_number', models.CharField(default=b' ', max_length=10, null=True)),
                ('account_id', models.ForeignKey(to='my_app.AccountID')),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='Address',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('attention', models.CharField(default=b' ', max_length=50, null=True)),
                ('address_line1', models.CharField(default=b' ', max_length=200, null=True)),
                ('address_line2', models.CharField(default=b' ', max_length=200, null=True)),
                ('city', models.CharField(default=b' ', max_length=50, null=True)),
                ('state', models.CharField(default=b'NY', max_length=2, null=True)),
                ('zipcode', models.CharField(default=b' ', max_length=5, null=True)),
                ('country', models.CharField(default=b'US', max_length=50)),
                ('is_billing', models.BooleanField(default=False)),
                ('is_ship_to', models.BooleanField(default=False)),
                ('account_id', models.ForeignKey(to='my_app.AccountID')),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='CompanyInfo',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('company_name', models.CharField(default=b' ', max_length=200, null=True)),
                ('company_url', models.CharField(default=b' ', max_length=50, null=True)),
                ('account_id', models.ForeignKey(to='my_app.AccountID')),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='Order',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('service_date', models.DateField(default=datetime.date(2014, 11, 29))),
                ('service_time', models.TimeField(default=datetime.time)),
                ('is_gift', models.BooleanField(default=False)),
                ('account_id', models.ForeignKey(to='my_app.AccountID')),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.CreateModel(
            name='Service',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('service_name', models.CharField(default=b' ', max_length=200, null=True)),
                ('service_description', models.TextField(default=b' ', max_length=400, null=True)),
                ('service_price', models.FloatField(default=b' ', max_length=8, null=True)),
            ],
            options={
            },
            bases=(models.Model,),
        ),
        migrations.AddField(
            model_name='order',
            name='service_name',
            field=models.ForeignKey(to='my_app.Service', null=True),
            preserve_default=True,
        ),
    ]
