#!/usr/bin/env bash
# For Linux use uuid, for Mac OS use uuidgen...
#export UUID=`uuid`
export UUID=`uuidgen`
export cmdURL="https://command-side-frail-chiffchaff.cfapps.io/"
export qryURL="https://query-side-runniest-inulase.cfapps.io/"
echo "CmdURL= ${cmdURL}"
echo "QryURL= ${qryURL}"
echo "Generated ProductID= ${UUID}"
curl -H "Content-Type:application/json" -d "{\"id\":\"${UUID}\", \"name\":\"test-${UUID}\"}" ${cmdURL}/add
curl -s ${qryURL}/products | grep test-${UUID}