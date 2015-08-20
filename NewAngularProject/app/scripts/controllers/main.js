'use strict';

angular.module('mytodoApp', [])
  .controller('MainCtrl', function ($scope, localStorageService) {
    //$scope.todos = [];
    //$scope.todos = ['Item 1', 'Item 2', 'Item 3'];

    var todosInStore = localStorageService.get('todos');

    $scope.todos = todosInStore || [];

    $scope.$watch('todos', function () {
      localStorageService.set('todos', $scope.todos);
    }, true);

    $scope.addTodo = function () {
      $scope.todos.push($scope.todo);
      $scope.todo = '';
    };
    $scope.removeTodo = function (index) {
      $scope.todos.splice(index, 1);
    };
  });
