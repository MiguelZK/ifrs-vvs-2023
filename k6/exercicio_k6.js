import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    stages: [
        {duration: '30s', target: 10 },
        {duration: '10s', target: 30 },
        {duration: '20s', target: 210 },
        {duration: '20s', target: 0 },
    ],
}

export default function() {
  let res = http.get('https://moodle.poa.ifrs.edu.br/');
  check(res, { 'status is 200': (r) => r.status === 200 });
  sleep(1);
}
