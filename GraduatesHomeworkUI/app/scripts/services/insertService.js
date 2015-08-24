/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('InsertService', function ($http) {
    return {
      newNode: function (nodeInfo) {
        return $http.post('http://localhost:8081/insert', nodeInfo);
      }
    }
  });


//angular.module('graduatesHomeworkUiApp')
//  .factory('InsertService', function ($http) {
//    return {
//      newNode: function (nodeInfo, callback) {
//        var res = $http.post('http://localhost:8081/insert', nodeInfo);
//        res.success(callback);
//        res.error(callback);
//      }
//    }
//  });
