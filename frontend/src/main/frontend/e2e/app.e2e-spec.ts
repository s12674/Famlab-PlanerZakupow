import { FamlabPage } from './app.po';

describe('famlab App', () => {
  let page: FamlabPage;

  beforeEach(() => {
    page = new FamlabPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
