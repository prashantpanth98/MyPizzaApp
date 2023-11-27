import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'userNamePipe'
})
export class UserNamePipePipe implements PipeTransform {

  transform(value: string) {
    return value.split("@")[0];
  }

}
