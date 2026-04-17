'use strict';

angular.module('productForm')
    .controller('ProductFormController', ["$http", '$state', '$stateParams', function ($http, $state, $stateParams) {
        var self = this;

        var productId = $stateParams.productId || 0;

        if (!productId) {
            self.product = {};
        } else {
            $http.get("api/inventory/products/" + productId).then(function (resp) {
                self.product = resp.data;
            });
        }

        self.submitProductForm = function () {
            var id = self.product.id;

            if (id) {
                $http.put('api/inventory/products/' + id, self.product).then(function () {
                    $state.go('products');
                });
            } else {
                $http.post('api/inventory/products', self.product).then(function () {
                    $state.go('products');
                });
            }
        };
    }]);
