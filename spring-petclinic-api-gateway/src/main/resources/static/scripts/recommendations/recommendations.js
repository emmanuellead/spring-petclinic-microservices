'use strict';

angular.module('recommendations', ['ui.router'])
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('recommendations', {
                parent: 'app',
                url: '/owners/:ownerId/recommendations',
                template: '<recommendations></recommendations>'
            })
    }]);
