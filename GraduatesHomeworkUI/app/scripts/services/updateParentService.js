/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('UpdateParentService', function ($http) {
    return {
      updateNodeParent: function (nodeInfo) {
        return $http.put('http://localhost:8081/updateParent', nodeInfo);
      }
    }
  });
