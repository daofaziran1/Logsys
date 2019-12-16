var mapechart=echarts.init(document.getElementById('map'));

var data = [
    //格式{name:'省份',value:'访问数'}
    {name: '河南', value: 279},
    {name:'北京',value:800}
];

var geoCoordMap = {
    '河南':[113.3,34.6],
    '北京':[116.395645,39.929986],
    '天津':[117.210813,39.14393],
    '河北':[114.522082,38.048958],
    '山西':[112.550864,37.890277],
    '内蒙古':[111.660351,40.828319],
    '辽宁':[123.432791,41.808645],
    '吉林':[125.3222,43.816],
    '黑龙江':[126.657717,45.773225],
    '上海':[121.4788,31.2303],
    '江苏':[118.778074,32.057236],
    '浙江':[120.219375,30.057236],
    '安徽':[117.282699,31.866942],
    '福建':[119.330221,26.047125],
    '江西':[115.893528,28.689578],
    '山东':[117.024967,36.682785],
    '湖北':[114.3162,30.581084],
    '湖南':[112.979353,28.213478],
    '广东':[113.30765,23.120049],
    '广西':[108.297234,22.806493],
    '海南':[110.330802,20.022071],
    '重庆':[106.55,29.5647],
    '四川':[104.0648,30.57],
    '贵州':[106.709177,26.629907],
    '云南':[102.714601,24.882],
    '西藏':[91.111891,29.662557],
    '陕西':[108.939,34.342],
    '甘肃':[103.823305,36.064226],
    '青海':[101.767921,36.640739],
    '宁夏':[106.206479,38.502621],
    '新疆':[87.564988,43.84038]
};

var convertData = function (data) {
    var res = [];
    for (var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name];
        if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value/2)
            });
        }
    }
    return res;
};

option = {
    backgroundColor: 'transparent',
    title: {
        text: '访问热度统计',
        left: 'center',
        textStyle: {
            color: '#fff'
        }
    },
    tooltip : {
        trigger: 'axis',
        formatter: function (params, ticket, callback) {
        return params.name+":"+params.value[2];
         }
//          {
//     componentType: 'series',
//     // 系列类型
//     seriesType: string,
//     // 系列在传入的 option.series 中的 index
//     seriesIndex: number,
//     // 系列名称
//     seriesName: string,
//     // 数据名，类目名
//     name: string,
//     // 数据在传入的 data 数组中的 index
//     dataIndex: number,
//     // 传入的原始数据项
//     data: Object,
//     // 传入的数据值
//     value: number|Array,
//     // 数据图形的颜色
//     color: string,

//     // 饼图的百分比
//     percent: number,

//     // 
//     galleryViewPath: ,

//     // 
//     galleryEditorPath: ,

//     // 
//     imagePath: ,

//     // 
//     gl: ,

// }
    },
    bmap: {
        center: [104.114129, 37.550339],
        zoom: 5,
        roam: true,
        mapStyle: {
            styleJson: [
                    {
                        "featureType": "water",
                        "elementType": "all",
                        "stylers": {
                            "color": "#044161"
                        }
                    },
                    {
                        "featureType": "land",
                        "elementType": "all",
                        "stylers": {
                            "color": "#004981"
                        }
                    },
                    {
                        "featureType": "boundary",
                        "elementType": "geometry",
                        "stylers": {
                            "color": "#064f85"
                        }
                    },
                    {
                        "featureType": "railway",
                        "elementType": "all",
                        "stylers": {
                            "visibility": "off"
                        }
                    },
                    {
                        "featureType": "highway",
                        "elementType": "geometry",
                        "stylers": {
                            "color": "#004981"
                        }
                    },
                    {
                        "featureType": "highway",
                        "elementType": "geometry.fill",
                        "stylers": {
                            "color": "#005b96",
                            "lightness": 1
                        }
                    },
                    {
                        "featureType": "highway",
                        "elementType": "labels",
                        "stylers": {
                            "visibility": "off"
                        }
                    },
                    {
                        "featureType": "arterial",
                        "elementType": "geometry",
                        "stylers": {
                            "color": "#004981"
                        }
                    },
                    {
                        "featureType": "arterial",
                        "elementType": "geometry.fill",
                        "stylers": {
                            "color": "#00508b"
                        }
                    },
                    {
                        "featureType": "poi",
                        "elementType": "all",
                        "stylers": {
                            "visibility": "off"
                        }
                    },
                    {
                        "featureType": "green",
                        "elementType": "all",
                        "stylers": {
                            "color": "#056197",
                            "visibility": "off"
                        }
                    },
                    {
                        "featureType": "subway",
                        "elementType": "all",
                        "stylers": {
                            "visibility": "off"
                        }
                    },
                    {
                        "featureType": "manmade",
                        "elementType": "all",
                        "stylers": {
                            "visibility": "off"
                        }
                    },
                    {
                        "featureType": "local",
                        "elementType": "all",
                        "stylers": {
                            "visibility": "off"
                        }
                    },
                    {
                        "featureType": "arterial",
                        "elementType": "labels",
                        "stylers": {
                            "visibility": "off"
                        }
                    },
                    {
                        "featureType": "boundary",
                        "elementType": "geometry.fill",
                        "stylers": {
                            "color": "#029fd4"
                        }
                    },
                    {
                        "featureType": "building",
                        "elementType": "all",
                        "stylers": {
                            "color": "#1a5787"
                        }
                    },
                    {
                        "featureType": "label",
                        "elementType": "all",
                        "stylers": {
                            "visibility": "off"
                        }
                    }
            ]
        }
    },
    series : [
        {
            name: '热度',
            type: 'scatter',
            coordinateSystem: 'bmap',
            data: convertData(data),
            symbolSize: function (val) {
                return val[2] /10;
            },
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: false
                },
                emphasis: {
                    formatter:'{b}',
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#ddb926'
                }
            }
        },
        {
            name: 'Top 5',
            type: 'effectScatter',
            coordinateSystem: 'bmap',
            data: convertData(data.sort(function (a, b) {
                return b.value - a.value;
            }).slice(0, 6)),
            symbolSize: function (val) {
                return val[2] /10;
            },
            showEffectOn: 'emphasis',
            rippleEffect: {
                brushType: 'stroke'
            },
            hoverAnimation: true,
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#f4e925',
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            },
            zlevel: 1
        },
        {
            type: 'custom',
            coordinateSystem: 'bmap',
            itemStyle: {
                normal: {
                    opacity: 0.5
                }
            },
            animation: false,
            silent: true,
            data: [1],
            z: -10
        }
    ]
};
mapechart.setOption(option);