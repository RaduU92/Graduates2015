/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('RootService', function ($http) {
    return {
      getRoot: function (callback) {
        $http.get('http://localhost:8081/getRoot').success(callback);
      }
    }
  });
