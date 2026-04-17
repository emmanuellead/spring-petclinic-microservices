'use strict';

angular.module('productList')
    .controller('ProductListController', ['$http', function ($http) {
        var self = this;

        $http.get('api/inventory/products').then(function (resp) {
            self.productList = resp.data;
        });
    }]);
