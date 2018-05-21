#!/bin/bash
cpuload=$(uptime | awk -F 'load average:' '{print $2}')
cpuload_1min=$(echo $cpuload | awk -F ',' '{print $1}')
cpuload_5min=$(echo $cpuload | awk -F ',' '{print $2}')
cpuload_15min=$(echo $cpuload | awk -F ',' '{print $3}')
echo "cpuload: " "1min="$cpuload_1min  "5min="$cpuload_1min  "15min="$cpuload_1min 

cpuidle_used=$(vmstat | tail -1 | awk '{printf("%d\n", $15)}')
cpuidle_free=$[100-$cpuidle_used]
echo "cpulide: " "cpuidle_used="$cpuidle_used"%" "cupidle_free="$cpuidle_free"%"

