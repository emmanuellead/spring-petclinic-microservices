'use strict';

angular.module('vetList')
    .controller('VetListController', ['$http', function ($http) {
        var self = this;

        $http.get('api/gateway/vets-with-ratings').then(function (resp) {
            self.vetList = resp.data;
        });
    }]);
