/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('UpdateService', function ($http) {
    return {
      updateNode: function (nodeInfo, callback) {
        var res = $http.put('http://localhost:8081/update', nodeInfo);
        res.success(callback);
        res.error(callback);
      }
    }
  });
