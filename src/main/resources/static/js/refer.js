
var mapechart=echarts.init(document.getElementById('map'));
var data=[];
function  get1(data){
    var dt=[];
    for(d of data ){
        dt.push(d.name);
    }
}
option = {
    title : {
        text: '某站点用户访问来源',
        subtext: '纯属虚构',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: get1(window.data)
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data: window.data,
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(1, 0, 1, 1.5)'
                }
            }
        }
    ]
};


mapechart.setOption(option);