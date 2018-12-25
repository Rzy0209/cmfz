<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_main" style="width: 600px;height: 400px;;margin-top: 30px;margin-left: 30px"></div>

<script type="text/javascript">
	 // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('statistics_main'));


        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '持名法州App活跃用户'
            },
            tooltip: {},
            legend: {
                data:["用户数量"]
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: []
            }]
        };
        
        myChart.setOption(option);

        // 异步加载统计信息
		$.post("${pageContext.request.contextPath }/user/showActive",function(data){
			console.log(data);

            var array1 = new Array();
            var array2 = new Array();
            for(var key in data) {
                array1.push(key);
                array2.push(data[key]);
            }

        	// 使用刚指定的配置项和数据显示图表。
            myChart.setOption({
                xAxis: {
                    data: array1
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '活跃用户',
                    data: array2
                }]
            });

        },"json");
</script>
