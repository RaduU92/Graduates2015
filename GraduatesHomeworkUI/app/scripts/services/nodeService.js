/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('NodeService', function ($http) {
    return {
      myNode: function (id, callback) {
        $http.get('http://localhost:8081/select/' + id).success(callback);
      }
    }
  });
