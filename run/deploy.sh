#!/usr/bin/env bash
#工程部署脚本，会首先编译代码，然后停止jetty，拷贝war包，启动jetty
#该脚本接受2个参数，第一个为jetty的根目录，第二个为部署使用的environment，若不传参数则使用如下默认值
jettyDir="/home/jayne/jetty"
environment="develop"
java_options="-Xmx200m"

if [ x$1 != x ];then
    jettyDir=$1
fi
if [ x$2 != x ];then
    environment=$2
fi

if [ x"$environment" = x"develop" ]; then
    java_options="-Xmx200m "
fi

rootDir=$(cd "$(dirname "$0")"/; pwd)/../
echo "project dir: "${rootDir}
echo "packaging ..."
chmod 755 ${rootDir}/run/*
mvn clean package -P${environment}

if [ $? -ne 0 ];then
    echo "package fail!"
    exit 1
fi

echo "jetty dir: "${jettyDir}
webDir=${jettyDir}/webapps
cd ${webDir}
echo "jetty stopping ..."
sh ../bin/jetty.sh stop

war=${rootDir}/target/springmvc.war
echo "war file: "${war}
echo "deploy war ..."
cp ${war} ${webDir}/root.war

cd ${webDir}
echo "jetty starting ..."
export JAVA_OPTIONS=${java_options}
sh ../bin/jetty.sh start

if [ $? -ne 0 ];then
    echo "start jetty fail!"
    exit 1
fi
