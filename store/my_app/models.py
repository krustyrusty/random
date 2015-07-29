from django.db import models
import datetime


class AccountID(models.Model):
    date_created = models.DateTimeField(default=datetime.datetime.today())

    def __str__(self):
        return str(self.date_created)


class CompanyInfo(models.Model):
    account_id = models.ForeignKey(AccountID)
    company_name = models.CharField(max_length=200, default=' ', null=True)
    company_url = models.CharField(max_length=50, default=' ', null=True)

    def __str__(self):
        return self.company_name


class AccountName(models.Model):
    account_id = models.ForeignKey(AccountID)
    first_name = models.CharField(max_length=50, default=' ', null=True)
    last_name = models.CharField(max_length=50, default=' ', null=True)
    email = models.CharField(max_length=75, default=' ', null=True)
    phone_number = models.CharField(max_length=10, default=' ', null=True)


class Address(models.Model):
    account_id = models.ForeignKey(AccountID)
    attention = models.CharField(max_length=50, default=' ', null=True)
    address_line1 = models.CharField(max_length=200, default=' ', null=True)
    address_line2 = models.CharField(max_length=200, default=' ', null=True)
    city = models.CharField(max_length=50, default=' ', null=True)
    state = models.CharField(max_length=2, default="NY", null=True)
    zipcode = models.CharField(max_length=5, default=' ', null=True)
    country = models.CharField(max_length=50, default="US")
    is_billing = models.BooleanField(default=False)
    #is_ship_to = models.BooleanField(default=False)


class Service(models.Model):
    service_name = models.CharField(max_length=200, default=' ', null=True)
    service_description = models.TextField(max_length=400, default=' ', null=True)
    service_price = models.FloatField(max_length=8, default=' ', null=True)

    def __str__(self):
        return self.service_name


#    def get_description(self):
 #       return self.service_description

#    def _get_service_info(self):
 #       return '%s %s' % (self.service_description, self.service_price)
#
 #   service_info = property(_get_service_info)

    class Meta:
        ordering = ["id"]


class Order(models.Model):
    account_id = models.ForeignKey(AccountID)
    service_name = models.ForeignKey(Service, null=True)
    service_date = models.DateField(default=datetime.date.today())
    service_time = models.TimeField(default=datetime.time)
    is_gift = models.BooleanField(default=False)