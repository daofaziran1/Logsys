function createcricle(locs){
var mapechart=echarts.init(document.getElementById('cricle'));
var data=[];

for(loc of locs){
    var t={name:'',value:0};
    t.name=loc.location;
    t.value=loc.num;
    data.push(t);
}
function  get1(data){
    var dt=[];
    for(d of data ){
        dt.push(d.name);
    }
    return dt;
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
        data: get1(data)
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data: data,
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
}