'use strict';

angular.module('recommendations')
    .controller('RecommendationsController', ['$http', '$stateParams', function ($http, $stateParams) {
        var self = this;
        var ownerId = $stateParams.ownerId;

        $http.get('api/gateway/owners/' + ownerId + '/suggest').then(function (resp) {
            self.recommendations = resp.data;
        });
    }]);
