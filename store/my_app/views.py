from django.shortcuts import render
from django.shortcuts import get_object_or_404, render
from django.http import HttpResponseRedirect
from django.core.urlresolvers import reverse
from django.views import generic
from django.utils import timezone #ADDED IN 9TH MODIFICATION
from django.http import HttpResponse    #ADDED THIS
from django.template import RequestContext, loader #ADDED IN 2nd MODIFICATION
from django.shortcuts import render     #ADDED IN 3rd MODIFICATION
from django.http import Http404         #ADDED IN 4th MODIFICATION
from django.shortcuts import get_object_or_404, render #ADDED IN 5TH MODIFICATION
from django.shortcuts import get_object_or_404  #ADDED IN 6TH MODIFICATION
from django.http import HttpResponseRedirect    #ADDED IN 6TH MODIFICATION
from django.core.urlresolvers import reverse    #ADDED IN 6TH MODIFICATION

from django.views import generic
from models import Service, AccountID, AccountName, Address, CompanyInfo, Order

from itertools import chain     #used to make multiple querysets in one view


class HomepageView(generic.ListView):
    template_name = 'my_app/homepage.html'
    context_object_name = 'list_of_services'

    def get_queryset(self):
        return Service.objects.all()


class DetailView(generic.DetailView):
    model = Service
    template_name = 'my_app/detail.html'


    def get_queryset(self):
        return Service.objects.all()


class AccountItemsView(generic.ListView):
    template_name = 'my_app/account_items.html'
    context_object_name = 'account_item_list'



    def get_queryset(self):
        accountname_list = AccountName.objects.all()
        companyinfo_list = CompanyInfo.objects.all()
        address_list = Address.objects.all()
        order_list = Order.objects.all()
  #      return AccountID.objects.all()
        #return AccountName.objects.all() + Address.objects.all()
        combine_list = list(chain(accountname_list, companyinfo_list, address_list, order_list))
        return combine_list

class NewUserDetailView(generic.DetailView):
    template_name = 'my_app/new_user.html'
    context_object_name = 'user_list'



    def get_queryset(self):
        accountname_list = AccountName.objects.all()
        companyinfo_list = CompanyInfo.objects.all()
        address_list = Address.objects.all()
        order_list = Order.objects.all()
        combine_list = list(chain(accountname_list, companyinfo_list, address_list, order_list))
        return combine_list