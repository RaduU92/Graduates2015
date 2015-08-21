/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('childrenApp', [])
  .controller('ChildrenCtrl', function getChildrens($scope, $http) {
    $http.get('http://localhost:8081/getChildrens/1').success(function (data) {
      $scope.childs = data;
    });
  });
