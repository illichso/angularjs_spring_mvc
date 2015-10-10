angular.module('ngBoilerplate.account', ['ui.router'])
    .config(function($stateProvider) {
        $stateProvider.state('login', {
            url: '/login',
            views: {
                'main': {
                    templateUrl: 'account/login.tpl.html',
                    controller: 'LoginCtrl'
                }
            },
            data : {pageTitle : "Login"}
        })
            .state('register', {
                url: '/register',
                views: {
                    'main': {
                        templateUrl: 'account/register.tpl.html'
                    }
                },
                data : {pageTitle : "Registration"}
            });
    })
    .controller("LoginCtrl", function($scope) {
        $scope.login = function() {
            alert('user logged in with ' + $scope.account.name + " and " + $scope.account.password);
        };
    });
