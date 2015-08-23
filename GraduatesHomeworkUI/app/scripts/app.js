'use strict';

/**
 * @ngdoc overview
 * @name graduatesHomeworkUiApp
 * @description
 * # graduatesHomeworkUiApp
 *
 * Main module of the application.
 */
angular
  .module('graduatesHomeworkUiApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/node', {
        templateUrl: 'views/node.html',
        controller: 'NodeCtrl',
        controllerAs: 'node'
      })
      .when('/children', {
        templateUrl: 'views/childrens.html',
        controller: 'ChildrenCtrl',
        controllerAs: 'child'
      })
      .when('/parent', {
        templateUrl: 'views/parent.html',
        controller: 'ParentCtrl',
        controllerAs: 'parent'
      })
      .when('/root', {
        templateUrl: 'views/root.html',
        controller: 'RootCtrl',
        controllerAs: 'root'
      })
      .when('/topDown', {
        templateUrl: 'views/topDown.html',
        controller: 'TopDownCtrl',
        controllerAs: 'topDown'
      })
      .when('/bottomUp', {
        templateUrl: 'views/bottomUp.html',
        controller: 'BottomUpCtrl',
        controllerAs: 'bottomUp'
      })
      .when('/insert', {
        templateUrl: 'views/insert.html',
        controller: 'InsertCtrl',
        controllerAs: 'insert'
      })
      .when('/update', {
        templateUrl: 'views/update.html',
        controller: 'UpdateCtrl',
        controllerAs: 'update'
      })
      .when('/updateParent', {
        templateUrl: 'views/updateParent.html',
        controller: 'UpdateParentCtrl',
        controllerAs: 'updateParent'
      })
      .when('/delete', {
        templateUrl: 'views/delete.html',
        controller: 'DeleteCtrl',
        controllerAs: 'delete'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
