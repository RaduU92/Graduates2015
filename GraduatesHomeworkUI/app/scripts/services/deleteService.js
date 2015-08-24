/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('DeleteService', function ($http) {
    return {
      deleteNode: function (nodeInfo) {
        return $http({method: 'DELETE', url: 'http://localhost:8081/delete', data: nodeInfo});
      }
    }
  });
