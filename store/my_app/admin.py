from django.contrib import admin
from models import Service, AccountID, AccountName, Address, Order, CompanyInfo

class OrderInline(admin.TabularInline):
    model = Order

class CompanyInfoInline(admin.StackedInline):
    model=CompanyInfo

class AddressInline(admin.StackedInline):
    model=Address
    extra = 1

class AccountNameInline(admin.TabularInline):
    model=AccountName
    extra = 1

class AccountIDAdmin(admin.ModelAdmin):
    fieldsets = [
        (None,                  {'fields': ['date_created']}),
    ]
    inlines = [CompanyInfoInline, AccountNameInline, AddressInline, OrderInline]
    #list_display = ('date_created' )
    #list_filter = ['date_created']
    #search_fields = ['date_created']

admin.site.register(AccountID, AccountIDAdmin)


class ServiceAdmin(admin.ModelAdmin):
    fieldsets = [
        (None,                  {'fields':['service_name', 'service_description', 'service_price']}),
    ]
    list_display = ('service_name', 'service_description', 'service_price')
    list_filter = ['service_name']
    search_fields = ['service_description']

admin.site.register(Service, ServiceAdmin)

